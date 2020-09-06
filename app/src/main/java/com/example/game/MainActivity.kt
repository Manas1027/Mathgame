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

        private var firstNumber: Int = 0
        private var secondNumber: Int = 0
        private var operator: String = ""
        private var levels: Int = 5
        private var answer: Int = 0
        private var questions: Int = 0
        private var durissan: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        playGame()
    }



        fun variantClick(button: View) {
            val saylanganJuwap = (button as Button).text.toString().toInt()
                questions++
            if(saylanganJuwap==answer){
                durissan++
                Toast.makeText(this, "Duris", Toast.LENGTH_SHORT).show()

                if(questions == levels){
                    val intent = Intent(this, SecondActivity::class.java)
                    intent.putExtra("right", "$durissan")
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                    startActivity(intent)
                }
                else{
                    playGame()
                }
            }
            else{
                if(questions == levels){
                    val intent = Intent(this, SecondActivity::class.java)
                    intent.putExtra("right", "$durissan")
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                    startActivity(intent)
                }
                else{
                    playGame()
                }

            }
        }


    private fun playGame(){
        firstNumber = generateRandomNumber(10, 100)
        secondNumber = generateRandomNumber(10, 100)
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