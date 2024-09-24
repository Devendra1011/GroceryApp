package com.example.groceryapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        // 1- AdapterView : RecyclerView
        var recyclerView:RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)


        // 2 - Data Source
        var groceryItems:ArrayList<Item> = ArrayList()
        val v1 = Item("Beverage","Cooled and Chilled Beverage",R.drawable.beverage)
        val v2 = Item("Bread","Fresh Baked Morning Brown Bread",R.drawable.bread)
        val v3 = Item("Fruits","Fresh Fruits From the Farm",R.drawable.fruit)
        val v4 = Item("Milk","Fresh Milk from the dairy",R.drawable.milk)
        val v5 = Item("Popcorn","Fried and Cheesy Popcorn ",R.drawable.popcorn)
        val v6 = Item("Beverage","Fresh and Organic Vegetables from Farmers",R.drawable.vegitables)

        groceryItems.add(v1)
        groceryItems.add(v2)
        groceryItems.add(v3)
        groceryItems.add(v4)
        groceryItems.add(v5)
        groceryItems.add(v6)

        val adapter = ItemAdapter(groceryItems)
        recyclerView.adapter = adapter











    }
}