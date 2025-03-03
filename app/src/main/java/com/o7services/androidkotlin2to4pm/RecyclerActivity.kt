package com.o7services.androidkotlin2to4pm

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.o7services.androidkotlin2to4pm.databinding.ActivityRecyclerBinding

class RecyclerActivity : AppCompatActivity() {
    lateinit var binding: ActivityRecyclerBinding
    lateinit var recyclerAdapter: RecylerAdapter
    var list= arrayListOf<Student>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityRecyclerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        list.add(Student(1,"A","Sub"))
        list.add(Student(1,"B","Sub"))
        list.add(Student(1,"C","Sub"))
        recyclerAdapter=RecylerAdapter(list)
        binding.recycler.layoutManager= LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        binding.recycler.adapter=recyclerAdapter
    }
}