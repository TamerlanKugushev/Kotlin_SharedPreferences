package com.example.kotlinsharedpreferences

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var counter = 0
    var test = "0"
    lateinit var sharedPreferences: SharedPreferences
    lateinit var tvResult: TextView
    lateinit var tvResult2: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvResult = findViewById(R.id.tvResult)
        tvResult2 = findViewById(R.id.tvResult2)
        sharedPreferences = getSharedPreferences("table", Context.MODE_PRIVATE)
        counter = sharedPreferences.getInt("counter", 0)
        test = sharedPreferences.getString("test", "0")!!
        tvResult.text = counter.toString()
        tvResult2.text = test

    }

    fun onClickAdd(view: View) {
        counter++
        tvResult.text = counter.toString()
        saveData(counter)
    }

    fun onClickDeleteItem(view: View) {
        deleteItem("counter")
    }

    fun onClickClearAll(view: View) {
        counter = 0
        deleteAll()
    }

    fun saveData(result: Int) {
        val editor = sharedPreferences.edit()
        editor.putInt("counter", result)
        editor.putString("test", "Test")
        editor.apply()
    }

    fun deleteAll() {
        val editor = sharedPreferences.edit()
        editor.clear()
        editor.apply()
    }

    fun deleteItem(deleteItem: String) {
        val editor = sharedPreferences.edit()
        editor.remove(deleteItem)
        editor.apply()
    }

    
}