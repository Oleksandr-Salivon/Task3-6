package com.example.task3_6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.textfield.TextInputLayout
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    var randomNumber = Random.nextInt(0, 1000)
    var limit = 12
    private var numberOfClicks =0
    var tmpValue=-1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val showResult = findViewById<TextView>(R.id.resultText)
        val inputText =findViewById<TextInputLayout>(R.id.number)
        val button = findViewById<TextView>(R.id.button)
        showResult.text = "$randomNumber" // I keep it for testing
        button.setOnClickListener {
            val getNumber = inputText.editText?.text
                    numberOfClicks++
            tmpValue = if (getNumber.isNullOrEmpty()) {
                -1
            } else {
                getNumber.toString().toInt()
            }
            if( (tmpValue < randomNumber || tmpValue > randomNumber ) && numberOfClicks >= limit) {
                newScreenIntent(numberOfClicks, randomNumber, "#ed1c43","You lost after" )
            } else
                    if(tmpValue > randomNumber && numberOfClicks <= limit ) {
                    showResult.text = "No, my number is smaller  $numberOfClicks"
                }
                else if(tmpValue < randomNumber && numberOfClicks <= limit) {
                    showResult.text = "No, my number is bigger $numberOfClicks"
                }
                else if (tmpValue == randomNumber && numberOfClicks <= limit){
                    showResult.text = " $numberOfClicks No, my number is bigger   $numberOfClicks"
                    newScreenIntent(numberOfClicks, randomNumber, "#22b162","You won after" )
                }
        }
    }
    private fun newScreenIntent( numberOfClick : Int, randomizeNumber: Int, color : String, msg : String){
        val newScreenIntent = Intent(this, GreetingActivity::class.java)
        newScreenIntent.putExtra("numberOfClick", "$msg $numberOfClick attempts! \n The number is ")
        newScreenIntent.putExtra("numberOfGuess", "$randomizeNumber")
        newScreenIntent.putExtra("color", color)
        startActivity(newScreenIntent)
    }
}