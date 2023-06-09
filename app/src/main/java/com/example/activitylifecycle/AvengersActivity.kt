package com.example.activitylifecycle

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class AvengersActivity : AppCompatActivity() {
    var titleName: String? = "Avengers"
    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences=getSharedPreferences(getString(R.string.preference_file_name),
            MODE_PRIVATE)
        setContentView(R.layout.scrollview_example)
        titleName=sharedPreferences.getString("Title","The Avengers")
        title =titleName
    }
}
