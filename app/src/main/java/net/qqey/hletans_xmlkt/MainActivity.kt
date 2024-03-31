package net.qqey.hletans_xmlkt

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.io.ByteArrayOutputStream
import java.io.InputStream
import java.net.URL
import javax.net.ssl.HttpsURLConnection
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
        
    }
}
