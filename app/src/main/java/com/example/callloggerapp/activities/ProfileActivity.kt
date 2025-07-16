package com.example.callloggerapp.activities

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.callloggerapp.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.name.text = "Admin"
        binding.role.text = "Manager / Admin"
        binding.email.text = "admin@example.com"

        binding.viewContactsButton.setOnClickListener {
            startActivity(Intent(this, ContactListActivity::class.java))
        }
        binding.viewCallLogButton.setOnClickListener {
            val intent = Intent(this, CallLogActivity::class.java)
            startActivity(intent)
        }
    }
}