package net.qqey.hletans_xmlkt

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.io.OutputStream
import java.io.OutputStreamWriter
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL
import java.util.Locale
import kotlin.concurrent.thread


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val homeLocation:EditText = findViewById(R.id.home_location_form)
        val currentLocation:EditText = findViewById(R.id.current_location_form)
        val travelMode:EditText = findViewById(R.id.travel_mode_form)
        val webhookURL:EditText = findViewById(R.id.webhook_url_form)
        val endpointURL:EditText = findViewById(R.id.endpoint_url_form)

        val getLocationButton: Button = findViewById(R.id.get_locate)
        val sendButton: Button = findViewById(R.id.send_button)

        getLocationButton.setOnClickListener {
            homeLocation.setText("35.681236,139.767125")
            currentLocation.setText("35.681236,139.767125")
            travelMode.setText("driving")
            webhookURL.setText("https://hooks.slack.com/services/T01JZQZQZ5X/B01JZQZQZ5X/1JZQZQZ5X")
            endpointURL.setText(postAPI())

        }
    }
    fun postAPI(): String {
        val url = "https://api.hletans.qqey.net/notification"
        val json = "{\"home_location\":\"35.681236,139.767125\",\"current_location\":\"35.681236,139.767125\",\"travel_mode\":\"driving\"}"
        val endpointURL = "https://hooks.slack.com/services/T01JZQZQZ5X/B01JZQZQZ5X/1JZQZQZ5X"
        thread {
            try {
                val url = URL(url)
                val con = url.openConnection() as HttpURLConnection
                con.requestMethod = "POST"
                con.setRequestProperty("Content-Type", "application/json; charset=utf-8")
                con.doOutput = true
                val os: OutputStream = con.outputStream
                val osw = OutputStreamWriter(os, "UTF-8")
                val bw = BufferedWriter(osw)
                bw.write(json)
                bw.flush()
                bw.close()
                osw.close()
                os.close()
                con.connect()
                val responseCode = con.responseCode
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    val `is`: InputStream = con.inputStream
                    val reader = BufferedReader(InputStreamReader(`is`))
                    val response = StringBuffer()
                    var inputLine: String?
                    while (reader.readLine().also { inputLine = it } != null) {
                        response.append(inputLine)
                    }
                    reader.close()
                    `is`.close()
                    println(response.toString())
                }
            } catch (e: MalformedURLException) {
                e.printStackTrace()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
        return endpointURL
    }
}
