package net.qqey.hletans_xmlkt

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val homeLocation:EditText = findViewById(R.id.home_location_form)
        val currentLocation:EditText = findViewById(R.id.current_location_form)
        val travelMode:EditText = findViewById(R.id.travel_mode_form)
        val webhookURL:EditText = findViewById(R.id.webhook_url_form)
        val endpointURL:EditText = findViewById(R.id.endpoint_url_form)

        val getLocationButton: Button = findViewById(R.id.get_locate)
        val sendButton: Button = findViewById(R.id.send_button)

    }
}
