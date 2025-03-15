package com.o7services.androidkotlin2to4pm

import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.messaging.FirebaseMessaging
import com.o7services.androidkotlin2to4pm.activity_fragment_interaction.InteractionBaseActivity
import com.o7services.androidkotlin2to4pm.databinding.ActivityMainBinding
import com.o7services.androidkotlin2to4pm.firebase.FirebaseAuthentication
import com.o7services.androidkotlin2to4pm.firebase.FirestoreActivity
import com.o7services.androidkotlin2to4pm.jetpack_nav_package.BaseActivity
import com.o7services.androidkotlin2to4pm.list_package.ListBaseAdapterActivity
import com.o7services.androidkotlin2to4pm.realtimedatabase.RealtimeActivity

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var button: Button? = null
    var editText: EditText? = null
    private val TAG = "FCM Logs"

    lateinit var sharedPreferences:SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPreferences=getSharedPreferences("Details", MODE_PRIVATE)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.POST_NOTIFICATIONS)
                != PackageManager.PERMISSION_GRANTED) {

                requestPermission()
            }
        }

        FirebaseMessaging.getInstance().token.addOnCompleteListener{ task ->
            if (!task.isSuccessful) {
                Log.w(TAG, "Fetching FCM registration token failed", task.exception)
            }

            // Get new FCM registration token
            val token = task.result

            Log.d(TAG, token)
//dZUBcVf9RbG0ZSgUDBvFQz:APA91bFA_RTfQXU74eJ_DEeh6Gyy09hVhp8zwfZXwbcu3EyMIKJaMfy4SlHzBNpksdP_DA3-jzWEn4EiM1f6SndsuyF6BMLK09OmisWb6E9hJAxGBgiTths
//cC2xhZz2RB-w7bEqZ5u1UA:APA91bGQfskGA6pWC4uK8vNUiQ17KPxXlSg0Ek72wf51yYJ1WM3CeCQ2D-bN1V9dR8bOWfZNBWPFifixqCXIFPRfMXSQcQvvDKKppNNsScQowncVqHzLx4U
        }

        if (sharedPreferences.getBoolean("dark",false)){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }else{
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
        Toast.makeText(this, "Oncreate", Toast.LENGTH_SHORT).show()
//        button=findViewById(R.id.btnClick)
        editText = findViewById(R.id.edt1)
        binding.btnClick.setOnClickListener {
            var intent = Intent(this, Activity2::class.java)
            var mydata = editText?.text.toString()
            intent.putExtra("data", mydata)
            startActivity(intent)
            Toast.makeText(this, editText?.text.toString(), Toast.LENGTH_SHORT).show()
        }
        binding.btnImplicit.setOnClickListener {
            var intent = Intent(this, ImplicitActivity::class.java)

            startActivity(intent)
        }
        binding.btnAlertDialog.setOnClickListener {
            var intent = Intent(this, AlertDialogActivity::class.java)
            startActivity(intent)
        }
        binding.btnNavScreen.setOnClickListener {
            var intent = Intent(this, BaseActivity::class.java)
            startActivity(intent)
        }
        binding.btnListScreen.setOnClickListener {
            var intent = Intent(this, ListActivity::class.java)
            startActivity(intent)
        }
        binding.btnSpinnerScreen.setOnClickListener {
            var intent = Intent(this, SpinnerActivity::class.java)
            startActivity(intent)
        }
        binding.btnListBaseAdapter.setOnClickListener {
            var intent = Intent(this, ListBaseAdapterActivity::class.java)
            startActivity(intent)
        }
        binding.btnFirebaseRegister.setOnClickListener {
            var intent = Intent(this, FirebaseAuthentication::class.java)
            startActivity(intent)
        }
        binding.btnFirestore.setOnClickListener {
            var intent = Intent(this, FirestoreActivity::class.java)
            startActivity(intent)
        }
        binding.btnRealtime.setOnClickListener {
            var intent = Intent(this, RealtimeActivity::class.java)
            startActivity(intent)
        }
        binding.btnInteractionActivity.setOnClickListener {
            var intent = Intent(this, InteractionBaseActivity::class.java)
            startActivity(intent)
        }
        binding.btnSharedPrefActivity.setOnClickListener {
            var intent = Intent(this, SharedPrefActivity::class.java)
            startActivity(intent)
        }

    }

    private fun requestPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            requestPermissions(arrayOf(android.Manifest.permission.POST_NOTIFICATIONS), 101)
        }
    }

//    override fun onStart() {
//        super.onStart()
//        Toast.makeText(this, "OnStart", Toast.LENGTH_SHORT).show()
//
//    }
//
//    override fun onResume() {
//        super.onResume()
//        Toast.makeText(this, "OnResume", Toast.LENGTH_SHORT).show()
//
//    }
//
//    override fun onPause() {
//        super.onPause()
//        Toast.makeText(this, "OnPause", Toast.LENGTH_SHORT).show()
//
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        Toast.makeText(this, "OnDestroy", Toast.LENGTH_SHORT).show()
//
//
//    }
//
//    override fun onRestart() {
//        super.onRestart()
//        Toast.makeText(this, "OnReStart", Toast.LENGTH_SHORT).show()
//
//    }
//
//    override fun onStop() {
//        super.onStop()
//        Toast.makeText(this, "OnStop", Toast.LENGTH_SHORT).show()
//
//    }

}