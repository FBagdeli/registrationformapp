package com.farshadchalenges.registrationformapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.farshadchalenges.registrationformapp.databinding.ActivitySummaryBinding

@Suppress("DEPRECATION")
class SummaryActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySummaryBinding
    private lateinit var user: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySummaryBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        retrieveUser()
        displayUser()
        setupClickListeners()
    }

    private fun retrieveUser() {
        user = intent.getSerializableExtra("User") as User
    }

    private fun displayUser() {
        binding.textViewFullName.text = user.getFullName()
        binding.textViewEmail.text = user.email
        binding.textViewPhone.text = user.phone
    }

    private fun setupClickListeners() {
        binding.textViewEmail.setOnClickListener {
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.data = Uri.parse("mailto:${user.email}")
            startActivity(intent)
        }
        binding.textViewPhone.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:${user.phone}")
            startActivity(intent)
        }
    }
}