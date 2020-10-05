package me.nemiron.hyperion.networkemulation

import android.content.Context
import okhttp3.Interceptor
import okhttp3.Interceptor.Chain
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

class NetworkEmulatorInterceptor(
    context: Context,
    private val noNetworkExceptionProvider: (request: Request) -> Exception = {
        IOException("NetworkEmulator: no internet connection")
    },
    private val failureExceptionProvider: (request: Request) -> Exception = {
        IOException("NetworkEmulator: request failed")
    }
) : Interceptor {

    private val config = QualityConfig(context)
    private val isFailure: Boolean
        get() = (0..100).random() < config.errorPercentage

    override fun intercept(chain: Chain): Response {
        if (!config.networkEnabled)
            throw noNetworkExceptionProvider.invoke(chain.request())
        doLatency()
        if (isFailure)
            throw failureExceptionProvider.invoke(chain.request())
        else
            return chain.proceed(chain.request())
    }

    private fun doLatency() {
        val latency = config.latencyMs
        if (latency > 0) {
            try {
                Thread.sleep(latency.toLong())
            } catch (e: InterruptedException) {
                throw IOException("NetworkEmulator: delay interrupted")
            }
        }
    }
}