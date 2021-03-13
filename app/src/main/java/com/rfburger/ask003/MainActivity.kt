package com.rfburger.ask003

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    // region setup
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val zipcodeEditText :EditText = findViewById(R.id.zipCode_EditText)
        val enterbutton : Button = findViewById(R.id.enterButton)

        enterbutton.setOnClickListener {
            val zipcode:String = zipcodeEditText.text.toString()

            if(zipcode.length == 5){
                Toast.makeText(this , zipcode , Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this , R.string.errorMessage , Toast.LENGTH_SHORT).show()
            }

        }
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }
    // endregion setup
    // region teardown

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    // endregion teardown


}