package com.o7services.androidkotlin2to4pm

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Activity2 : AppCompatActivity() {
    var getData:String?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        getData= intent.getStringExtra("data")
        Toast.makeText(this, "$getData", Toast.LENGTH_SHORT).show()

        findViewById<TextView>(R.id.tvData).setText("$getData")

    }
    override fun onStart() {
        super.onStart()
//        Toast.makeText(this, "OnStart", Toast.LENGTH_SHORT).show()

    }

    override fun onResume() {
        super.onResume()
//        Toast.makeText(this, "OnResume", Toast.LENGTH_SHORT).show()

    }

    override fun onPause() {
        super.onPause()
//        Toast.makeText(this, "OnPause", Toast.LENGTH_SHORT).show()

    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "OnDestroy", Toast.LENGTH_SHORT).show()


    }

    override fun onRestart() {
        super.onRestart()
//        Toast.makeText(this, "OnReStart", Toast.LENGTH_SHORT).show()

    }

    override fun onStop() {
        super.onStop()
//        Toast.makeText(this, "OnStop", Toast.LENGTH_SHORT).show()
    }
}