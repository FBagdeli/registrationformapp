package com.farshadchalenges.registrationformapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.farshadchalenges.registrationformapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setupButton()
        setupSpinner()
    }
    private fun setupButton() {
        binding.buttonCreatAccount.setOnClickListener {
            creatAccount()
        }
    }
    private fun setupSpinner() {
        val titles = arrayOf("Miss","Mrs","Ms","Mr","Dr","Prof")
        val titlesAdapter = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,titles)
        binding.spinnerTitle.adapter=titlesAdapter
    }
    private fun creatAccount(){
        val user = User(
            binding.spinnerTitle.selectedItem as String,
            binding.textInputEditTextFirstName.toString(),
            binding.textInputEditTextLastName.toString(),
            binding.textInputEditTextEmail.toString(),
            binding.textInputEditTextPhone.toString(),
            binding.textInputEditTextPassword.toString(),
        )
        val intent = Intent(this,SummaryActivity::class.java)
        intent.putExtra("User",user)
        startActivity(intent)
    }
}