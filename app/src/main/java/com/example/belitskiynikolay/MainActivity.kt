package com.example.belitskiynikolay
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(
            findViewById<View>(R.id.main)
        ) { v: View, insets: WindowInsetsCompat ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        Log.d(TAG, "onCreate: Activity создана")

        // это когда программно идем через  button_programmatic
        val buttonProgrammatic = findViewById<Button>(R.id.button_programmatic)
        buttonProgrammatic.setOnClickListener { // получить данные
            val editTextName = findViewById<EditText>(R.id.editTextName)
            val editTextGroup = findViewById<EditText>(R.id.editTextGroup)
            val editTextAge = findViewById<EditText>(R.id.editTextAge)
            val editTextGrade = findViewById<EditText>(R.id.editTextGrade)

            val name = editTextName.text.toString()
            val group = editTextGroup.text.toString()
            val age = editTextAge.text.toString().toInt()
            val grade = editTextGrade.text.toString().toInt()


            val intent = Intent(
                this@MainActivity,
                SecondActivity::class.java
            )
            intent.putExtra("name", name)
            intent.putExtra("group", group)
            intent.putExtra("age", age)
            intent.putExtra("grade", grade)
            startActivity(intent)
        }
    }

    // когда жмем на button_declarative
    fun onDeclarativeClick(view: View?) {
        // данные не передаются как в програмном
        val intent = Intent(
            this,
            SecondActivity::class.java
        )
        startActivity(intent)
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: Activity стала видимой")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: Activity готова к взаимодействию")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: Activity приостановлена")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: Activity остановлена")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy: Activity уничтожена")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart: Activity перезапущена")
    }

    companion object {
        private const val TAG = "ASDFG"
    }
}