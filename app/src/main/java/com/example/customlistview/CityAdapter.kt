package com.example.customlistview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class CityAdapter(val cityData:Array<city>):BaseAdapter() {
    override fun getCount(): Int {
         return cityData.size
    }

    override fun getItem(position: Int): city {
         return cityData[position]
    }

    override fun getItemId(position: Int): Long {
         return cityData[position].name.hashCode().toLong()
    }

    override fun getView(position: Int, countView: View?, container: ViewGroup?): View {
         val convertView=LayoutInflater.from(container?.context ).inflate(R.layout.city_item,container, false)
         val cityCountry:TextView=convertView.findViewById(R.id.city_country)
        val cityName:TextView=convertView.findViewById(R.id.city_name)
        cityCountry.text=getItem(position).country;
        cityName.text=getItem(position).name
        return convertView
    }
}