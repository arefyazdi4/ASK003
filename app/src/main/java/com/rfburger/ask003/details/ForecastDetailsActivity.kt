package com.rfburger.ask003.details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
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

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //Handle item selected
        return when (item.itemId) {
            R.id.temp_settings-> {
                // do some thing
                showTempDisplaySettingDialog()
                true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    private fun showTempDisplaySettingDialog() {
        val dialogBuilder = AlertDialog.Builder(this)
                .setTitle("Chose Display Units")
                .setMessage("Chose one temperature unit to use for Display temperature")
                .setPositiveButton("F°"){ _, _ ->
                    Toast.makeText(this, "F°" , Toast.LENGTH_SHORT).show()
                }
                .setNeutralButton("C°"){_,_ ->
                    Toast.makeText(this, "C°" , Toast.LENGTH_SHORT).show()
                }
                .setOnDismissListener{
                    Toast.makeText(this, "dismiss" , Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("Kelvin"){ _,_ ->
                    Toast.makeText(this, "K°" , Toast.LENGTH_SHORT).show()
                }
        dialogBuilder.show()
    }
}