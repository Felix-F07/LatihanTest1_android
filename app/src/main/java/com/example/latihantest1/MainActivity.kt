package com.example.latihantest1

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var tvRole: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvEmail = findViewById<TextView>(R.id.tvEmail)
        val tvPhone = findViewById<TextView>(R.id.tvPhone)

        tvRole = findViewById(R.id.tvRole)

        // Klik Email
        tvEmail.setOnClickListener {

            val emailIntent = Intent(
                Intent.ACTION_SENDTO,
                Uri.parse("mailto:sarah@school.edu")
            )

            startActivity(emailIntent)
        }

        // Klik Phone
        tvPhone.setOnClickListener {

            val phoneIntent = Intent(
                Intent.ACTION_DIAL,
                Uri.parse("tel:+15559876547")
            )

            startActivity(phoneIntent)
        }

        // Klik Role
        tvRole.setOnClickListener {

            val roleIntent = Intent(
                this,
                RoleActivity::class.java
            )

            startActivityForResult(roleIntent, 100)
        }
    }

    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?
    ) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 100 && resultCode == RESULT_OK) {

            val role = data?.getStringExtra("role")

            if (role != null) {
                tvRole.text = "Role\n$role"
            }
        }
    }
}