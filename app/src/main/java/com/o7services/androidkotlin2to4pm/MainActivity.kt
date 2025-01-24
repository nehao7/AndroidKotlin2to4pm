package com.o7services.androidkotlin2to4pm

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.o7services.androidkotlin2to4pm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    var button : Button?=null
    var editText:EditText?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        Toast.makeText(this, "Oncreate", Toast.LENGTH_SHORT).show()
//        button=findViewById(R.id.btnClick)
        editText=findViewById(R.id.edt1)
        binding.btnClick.setOnClickListener {
            var intent=Intent(this,Activity2::class.java)
            var mydata=editText?.text.toString()
            intent.putExtra("data",mydata)
            startActivity(intent)
            Toast.makeText(this,editText?.text.toString(),Toast.LENGTH_SHORT).show()
        }
         binding.btnImplicit.setOnClickListener {
            var intent=Intent(this,ImplicitActivity::class.java)

            startActivity(intent)
        }
         binding.btnAlertDialog.setOnClickListener {
            var intent=Intent(this,AlertDialogActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(this, "OnStart", Toast.LENGTH_SHORT).show()

    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this, "OnResume", Toast.LENGTH_SHORT).show()

    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(this, "OnPause", Toast.LENGTH_SHORT).show()

    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "OnDestroy", Toast.LENGTH_SHORT).show()


    }

    override fun onRestart() {
        super.onRestart()
        Toast.makeText(this, "OnReStart", Toast.LENGTH_SHORT).show()

    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(this, "OnStop", Toast.LENGTH_SHORT).show()

    }

}