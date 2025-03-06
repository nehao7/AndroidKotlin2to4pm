package com.o7services.androidkotlin2to4pm.activity_fragment_interaction

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.o7services.androidkotlin2to4pm.R
import com.o7services.androidkotlin2to4pm.databinding.ActivityBase2Binding
import com.o7services.androidkotlin2to4pm.databinding.ActivityBaseBinding
import com.o7services.androidkotlin4_6pmmcpc.fragments.InteractionInterface

class BaseActivity : AppCompatActivity() {
    lateinit var binding:ActivityBase2Binding
    var interactionInterface:InteractionInterface?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityBase2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.btnTitle.setOnClickListener {
            interactionInterface?.changeColor()
        }

    }

    fun changeText(){
        binding.btnTitle.setText("Changed by fragment")
    }
}