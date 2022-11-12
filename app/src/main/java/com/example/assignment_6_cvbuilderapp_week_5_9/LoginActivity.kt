package com.example.assignment_6_cvbuilderapp_week_5_9

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Button
import android.widget.EditText
import com.example.assignment_6_cvbuilderapp_week_5_9.databinding.ActivityLoginBinding
import com.example.assignment_6_cvbuilderapp_week_5_9.databinding.ActivityMainBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        val sharedPref = getPreferences(Context.MODE_PRIVATE) ?: return

        findViewById<Button>(R.id.button_login).setOnClickListener {
            findViewById<EditText>(R.id.editTextTextEmailAddress)
            val savedUsername = sharedPref.getInt(findViewById<EditText>(R.id.editTextTextEmailAddress).text.toString(), 0)
            val savedPassword = sharedPref.getInt(findViewById<EditText>(R.id.editTextTextPassword).text.toString(), 0)

            if (resources.getString(savedUsername) == "username" && resources.getString(savedPassword) == "password") {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }

        // test
        findViewById<EditText>(R.id.editTextTextEmailAddress).setText("ale@miu.edu")
        findViewById<EditText>(R.id.editTextTextPassword).setText("ale")
        //

        with (sharedPref.edit()) {
            putInt("ale@miu.edu", R.string.username)
            putInt("ale", R.string.password)
            apply()
        }
    }
}