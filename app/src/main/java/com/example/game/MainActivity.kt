package com.example.game

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

        companion object{
            const val LEVEL_COUNT = 10
            const val RIGHT_ANSWERS_COUNT = "rightAnswersCount"
        }
    private val random = Random()
    var answer: Int = 0
    private var currentLevelCount = 1
    private var rightAnswers = 0
    private var wrongAnswers = 0
    private var operator: String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        playGame()
    }



        fun variantClick(button: View) {
            val saylanganJuwap = (button as Button).text.toString().toInt()
            if(saylanganJuwap == answer){
                rightAnswers++
            }
            else{
                wrongAnswers++
            }


            if(currentLevelCount== LEVEL_COUNT) {
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra(RIGHT_ANSWERS_COUNT, rightAnswers)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(intent)
                finish()
            }
            else{
                playGame()
            }
        }



    private fun playGame(){
        var firstNumber = generateRandomNumber(10, 100)
        var secondNumber = generateRandomNumber(10, 100)
        operator = generateRandomOperator()
        tvFirstNumber.text = firstNumber.toString()
        tvSecondNumber.text = secondNumber.toString()
        tvOperator.text = operator
        generateWrongAnswers()
        setRightAnswer()
    }

    private fun generateRandomNumber(start: Int, end: Int): Int = Random.nextInt(start, end)

    fun generateRandomOperator(): String {
        return when(generateRandomNumber(0, 4)){
            0 -> "+"
            1 -> "-"
            2 -> "*"
            3 -> "/"
            else -> "+"
        }
    }

    private fun generateWrongAnswers(){
        answer = getRightAnswer()
        val variantA = when(generateRandomNumber(0, 2)){
            0 -> answer + generateRandomNumber(3, answer)
            1 -> answer - generateRandomNumber(3, answer)
            else -> answer + generateRandomNumber(3, answer)
        }
        val variantB = when(generateRandomNumber(0, 2)){
            0 -> answer + generateRandomNumber(3, answer)
            1 -> answer - generateRandomNumber(3, answer)
            else -> answer + generateRandomNumber(3, answer)
        }
        val variantC = when(generateRandomNumber(0, 2)){
            0 -> answer + generateRandomNumber(3, answer)
            1 -> answer - generateRandomNumber(3, answer)
            else -> answer + generateRandomNumber(3, answer)
        }
        val variantD = when(generateRandomNumber(0, 2)){
            0 -> answer + generateRandomNumber(3, answer)
            1 -> answer - generateRandomNumber(3, answer)
            else -> answer + generateRandomNumber(3, answer)
        }
        btnA.text = variantA.toString()
        btnB.text = variantB.toString()
        btnC.text = variantC.toString()
        btnD.text = variantD.toString()
    }

        fun getRightAnswer(): Int {
            return when(operator){
                "+" -> firstNumber + secondNumber
                "-" -> firstNumber - secondNumber
                "*" -> firstNumber * secondNumber
                "/" -> firstNumber / secondNumber
                else -> firstNumber + secondNumber
            }
        }

        fun setRightAnswer(){
            when(generateRandomNumber(0, 4)){
                0 -> btnA.text = getRightAnswer().toString()
                1 -> btnB.text = getRightAnswer().toString()
                2 -> btnC.text = getRightAnswer().toString()
                3 -> btnD.text = getRightAnswer().toString()
                else -> btnA.text = getRightAnswer().toString()
            }
        }

}