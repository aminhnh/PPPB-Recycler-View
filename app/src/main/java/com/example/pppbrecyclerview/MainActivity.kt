package com.example.pppbrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pppbrecyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapterRestaurant = RestaurantAdapter(generateRestaurant()) {
            restaurant -> Toast.makeText(this@MainActivity, "You clicked on ${restaurant.name}", Toast.LENGTH_SHORT).show()
        }
        with(binding){
            rvRestaurants.apply {
                adapter = adapterRestaurant
                layoutManager = LinearLayoutManager(this@MainActivity)
                //layoutManager = GridLayoutManager(this@MainActivity, 2)
            }
        }
    }

    fun generateRestaurant() : List<Restaurant>{
        return listOf(
            Restaurant(name="Warung Steak", type = "Indonesian"),
            Restaurant(name="Sushi Tei", type = "Japanese"),
            Restaurant(name="Mas Kobis", type = "Javanese"),
        )
    }
}