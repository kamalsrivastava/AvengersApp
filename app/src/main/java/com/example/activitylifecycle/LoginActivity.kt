package com.example.activitylifecycle

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LoginActivity() : AppCompatActivity() {
    lateinit var etMobileNumber: EditText
    lateinit var etPassword: EditText
    lateinit var btnLogin: Button
    lateinit var txtForgotPassword: TextView
    lateinit var txtRegister: TextView
    val validMobileNumber="12345"
    val validPassword= arrayOf("tony","steve","bruce","thanos")
    lateinit var  sharedPreference: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreference=getSharedPreferences(getString(R.string.preference_file_name),
            MODE_PRIVATE)
        val issLoggedIn = sharedPreference.getBoolean("isLoggedIn",false)
        setContentView(R.layout.activity_new2)
        if(issLoggedIn){
            val intent=Intent(this@LoginActivity,AvengersActivity::class.java)
            startActivity(intent)
            finish()
        }
        setContentView(R.layout.activity_new2)
        etMobileNumber=findViewById(R.id.etMobileNumber)
        etPassword=findViewById(R.id.etPassword)
        btnLogin=findViewById(R.id.btLogin)
        txtForgotPassword=findViewById(R.id.txtForgotPassword)
        txtRegister=findViewById(R.id.txtRegister)
        title="Log In"
        btnLogin.setOnClickListener {
            val mobileNumber=etMobileNumber.text.toString()
            val password=etPassword.text.toString()
            var nameofAvenger="Avenger"
            val intent=Intent(this@LoginActivity,AvengersActivity::class.java)
            if(mobileNumber==validMobileNumber){
                if (password==validPassword[0]){
                    nameofAvenger="Iron Man"
                    savePreferences(nameofAvenger)
                    startActivity(intent)
                }
                else if(password==validPassword[1]){
                    nameofAvenger="Captain America"
                    savePreferences(nameofAvenger)
                    startActivity(intent)
                }
                else if(password==validPassword[2]){
                    nameofAvenger="Strongest Avenger"
                    savePreferences(nameofAvenger)
                    startActivity(intent)
                }
                else if(password==validPassword[3]){
                    nameofAvenger="The Avengers"
                    savePreferences(nameofAvenger)
                    intent.putExtra("Name",nameofAvenger)
                    startActivity(intent)
                }
            }
            else{
                Toast.makeText(this@LoginActivity,"Invalid Credentials",Toast.LENGTH_LONG).show()
            }
        }

    }

    override fun onPause() {
        super.onPause()
        finish()
    }
    fun savePreferences(title: String){
        sharedPreference.edit().putBoolean("isLoggedIn", true).apply()
        sharedPreference.edit().putString("Title",title).apply()
    }
}


