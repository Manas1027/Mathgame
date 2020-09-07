package com.example.game

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        var rightAnsewrCount = intent.getIntExtra(MainActivity.RIGHT_ANSWERS_COUNT, 0)
        tvResult.text = "Your score is "+rightAnsewrCount/ ${MainActivity.LEVEL_COUNT}
    }
}