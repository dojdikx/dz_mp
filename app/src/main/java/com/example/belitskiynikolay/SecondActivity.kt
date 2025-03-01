package com.example.belitskiynikolay

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val textViewData = findViewById<TextView>(R.id.textViewData)
        val extras = intent.extras
        if (extras != null) {
            val name = extras.getString("name", "Не указано")
            val group = extras.getString("group", "Не указано")
            val age = extras.getInt("age", 0)
            val grade = extras.getInt("grade", 0)
            val data = ("""
     ФИО: $name
     Номер группы: $group
     Возраст: $age
     Оценка: $grade
     """.trimIndent())
            textViewData.text = data
        } else {
            textViewData.text = "Данные не переданы"
        }
    }
}