package com.rfburger.ask003.details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.widget.TextView
import com.rfburger.ask003.R
import com.rfburger.ask003.formatTempForDisplay

class ForecastDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forecast_details)

        setTitle(R.string.forecast_detail)

        val tempTextLarge :TextView = findViewById(R.id.tempTextLarge)
        val descriptionTextLarge : TextView = findViewById(R.id.descriptionTextLarge)

        val temp = intent.getFloatExtra("key_temp" , 0F)
        val description = intent.getStringExtra("key_description")

        tempTextLarge.text = formatTempForDisplay(temp)
        descriptionTextLarge.text = description

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater :MenuInflater = menuInflater
        inflater.inflate(R.menu.settings_menu , menu)
        return true
    }
}