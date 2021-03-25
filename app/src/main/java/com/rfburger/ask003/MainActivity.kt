package com.rfburger.ask003

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rfburger.ask003.details.ForecastDetailsActivity


class MainActivity : AppCompatActivity() {

    private val forecastRepository = ForecastRepository()
    // region setup
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val zipcodeEditText: EditText = findViewById(R.id.zipCode_EditText)
        val enterButton: Button = findViewById(R.id.enterButton)

        enterButton.setOnClickListener {
            val zipcode: String = zipcodeEditText.text.toString()

            if (zipcode.length == 5) {
                forecastRepository.loadForecast(zipcode)
            }else{
                Toast.makeText(this, R.string.errorMessage, Toast.LENGTH_SHORT).show()
            }

        }




        val forecastList : RecyclerView = findViewById(R.id.forecastList)
        forecastList.layoutManager = LinearLayoutManager(this)

        val dailyForecastAdapter = DailyForecastAdapter(){forecast ->
            showForecastDetail(forecast)
            //val msg = getString(R.string.forecast_clicked_format , it.temp , it.description)
            //Toast.makeText(this, msg , Toast.LENGTH_SHORT).show()
        }

        forecastList.adapter = dailyForecastAdapter

        val weeklyForecastObserver = Observer<List<DailyForecast>>{ forecastItems ->
            //Update our list adapter
                dailyForecastAdapter.submitList(forecastItems)
        }
        forecastRepository.weeklyForecast.observe(this , weeklyForecastObserver)


    }

    private fun  showForecastDetail (forecast : DailyForecast){
        val forecastDetailsIntent = Intent(this , ForecastDetailsActivity::class.java)
        forecastDetailsIntent.putExtra("key_temp" , forecast.temp)
        forecastDetailsIntent.putExtra("key_description" , forecast.description)
        startActivity(forecastDetailsIntent)
    }

}








//
//    override fun onStart() {
//        super.onStart()
//    }
//
//    override fun onResume() {
//        super.onResume()
//    }
//    // endregion setup
//    // region teardown
//
//    override fun onPause() {
//        super.onPause()
//    }
//
//    override fun onStop() {
//        super.onStop()
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//    }
//
//    // endregion teardown

