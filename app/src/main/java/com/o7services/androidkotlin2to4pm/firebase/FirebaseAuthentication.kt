package com.o7services.androidkotlin2to4pm.firebase

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.auth.FirebaseAuth
import com.o7services.androidkotlin2to4pm.R
import com.o7services.androidkotlin2to4pm.databinding.ActivityFirebaseAuthenticationBinding

class FirebaseAuthentication : AppCompatActivity() {
    lateinit var binding: ActivityFirebaseAuthenticationBinding
    var auth = FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityFirebaseAuthenticationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.etRegister.setOnClickListener {
            if ( binding.etEmail.text.toString().isNullOrEmpty()) {
                binding.etEmail.error="Enter the email"
                Toast.makeText(this, "Enter email", Toast.LENGTH_SHORT).show()
            }else if (binding.etPswd.text.toString().isNullOrEmpty()){
                binding.etEmail.error="Enter the password"
                Toast.makeText(this, "Enter password", Toast.LENGTH_SHORT).show()

            }else{
            auth.createUserWithEmailAndPassword(
                binding.etEmail.text.toString(),
                binding.etPswd.text.toString()
            ).addOnSuccessListener {
                Toast.makeText(this, "Successfully Registered", Toast.LENGTH_SHORT).show()

            }.addOnFailureListener {
                Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()

            }
            }
        }
    }
}