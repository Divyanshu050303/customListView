package com.example.customlistview

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

const val FAVORITE_KEY="FAVORITE_KEY"
class MainActivity : AppCompatActivity() {
    val cityData=fillCityDat();
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
loadFavorites()
        val cities=findViewById<ListView>(R.id.cities)
        val cityAdapter=CityAdapter(cityData)
        cities.adapter=cityAdapter
        cities.setOnItemClickListener{
            parent, view, position, id->
            val city:City?=cityAdapter.getItem(position)
            city?.let{
                city.favorite=!city.favorite
                cityAdapter.notifyDataSetChanged()
            }
            saveFavorite()
        }
    }
    private fun saveFavorite(){
        val favorites=cityData.filter { it.favorite }.map { it.country }
        val sharedPref=getPreferences(Context.MODE_PRIVATE)
        with(sharedPref.edit()){
            putStringSet(FAVORITE_KEY, favorites.toSet())
            commit()
        }
    }
    private fun loadFavorites(){
        val sharedPref =getPreferences(Context.MODE_PRIVATE)
        val favorites=sharedPref.getStringSet(FAVORITE_KEY, null)
        favorites?.forEach{Country->
        val city=cityData.find { it.country==Country }
        city?.favorite=true}
    }
    private fun fillCityDat():Array<City>{
        return arrayOf(City("India", "New Delhi"),
            City("USA", "New York"),
            City("France", "Paris"),
            City("Italy", "Rome"),
            City("Netherlands", "Amsterdam"))
    }
}