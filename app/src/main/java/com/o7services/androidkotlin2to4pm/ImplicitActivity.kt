package com.o7services.androidkotlin2to4pm

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ImplicitActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_implicit)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        findViewById<Button>(R.id.btnUrl).setOnClickListener {
            var intent= Intent(Intent.ACTION_VIEW)
            Intent()
            intent.setData(Uri.parse("https://o7services.com/"))
            startActivity(intent)
        }

        findViewById<Button>(R.id.btnDial).setOnClickListener {
            var intent = Intent(Intent.ACTION_DIAL)
            intent.setData(Uri.parse("tel:98765432"))
            startActivity(intent)
        }

    }
}