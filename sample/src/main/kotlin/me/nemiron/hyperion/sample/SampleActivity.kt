package me.nemiron.hyperion.sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.chuckerteam.chucker.api.ChuckerInterceptor
import kotlinx.android.synthetic.main.activity_sample.*
import me.nemiron.hyperion.networkemulation.NetworkEmulatorInterceptor
import okhttp3.*
import java.io.IOException

class SampleActivity : AppCompatActivity() {

    private val client: OkHttpClient by lazy {
        OkHttpClient.Builder()
            .addInterceptor(NetworkEmulatorInterceptor(this))
            .addInterceptor(ChuckerInterceptor(this))
            .build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample)
        button.setOnClickListener { sendRequest() }
    }

    private fun sendRequest() {
        loading.visibility = View.VISIBLE
        button.isEnabled = false
        val request = Request.Builder()
            .url("https://www.squareup.com/why-square")
            .build()
        val call = client.newCall(request)

        call.enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) =
                stopLoading("Exception occurred: ${e.message}")

            override fun onResponse(call: Call, response: Response) =
                stopLoading("response successful: ${response.isSuccessful}")

        })
    }

    private fun stopLoading(message: String) = runOnUiThread {
        loading.visibility = View.GONE
        button.isEnabled = true
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }
}