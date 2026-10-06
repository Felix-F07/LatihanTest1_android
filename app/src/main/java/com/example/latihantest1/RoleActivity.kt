package com.example.latihantest1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class RoleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_role)

        val btnAdmin = findViewById<Button>(R.id.btnAdmin)
        val btnUser = findViewById<Button>(R.id.btnUser)
        val btnGuest = findViewById<Button>(R.id.btnGuest)

        btnAdmin.setOnClickListener {
            kirimRole("Admin")
        }

        btnUser.setOnClickListener {
            kirimRole("User")
        }

        btnGuest.setOnClickListener {
            kirimRole("Guest")
        }
    }

    private fun kirimRole(role: String) {
        val intent = Intent()
        intent.putExtra("role", role)

        setResult(RESULT_OK, intent)
        finish()
    }
}