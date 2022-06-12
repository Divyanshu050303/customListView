package com.example.customlistview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val cityData= arrayOf(city("India", "New Delhi"),
            city("USA", "New York"),
            city("France", "Paris"),
            city("Italy", "Rome"),
            city("Netherlands", "Amsterdam"))
        val cities=findViewById<ListView>(R.id.cities)
        val cityAdapter=CityAdapter(cityData)
        cities.adapter=cityAdapter
    }
}