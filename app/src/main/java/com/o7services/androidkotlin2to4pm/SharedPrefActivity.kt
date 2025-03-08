package com.o7services.androidkotlin2to4pm

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.o7services.androidkotlin2to4pm.databinding.ActivitySharedPrefBinding

class SharedPrefActivity : AppCompatActivity() {
    lateinit var binding:ActivitySharedPrefBinding
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivitySharedPrefBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //initialize
        sharedPreferences=getSharedPreferences("Details", MODE_PRIVATE)
        loadData()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val editor=sharedPreferences.edit()
        binding.btnSave.setOnClickListener {
           var name=binding.edtName.text.toString()
            editor.putString("name",name)
            editor.commit()
            editor.apply()
            Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show()
        }

        binding.btnDelete.setOnClickListener {
            editor.remove("name")
            editor.apply()
            loadData()
            Toast.makeText(this, "Deleted", Toast.LENGTH_SHORT).show()


        }
        binding.btnChangeMode.setOnClickListener {
            AlertDialog.Builder(this).apply {
                setTitle("Change App Mode")
                setPositiveButton("Light"){_,_->
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                    editor.putBoolean("dark",false)
                    editor.apply()

                }
                setNegativeButton("Dark"){_,_->
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                    editor.putBoolean("dark",true)
                    editor.apply()
                }
                show()
            }
        }


    }
    fun loadData(){
        var name=sharedPreferences.getString("name","")
        binding.edtName.setText(name)
        if (sharedPreferences.getBoolean("dark",false)){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }else{
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
    }
}