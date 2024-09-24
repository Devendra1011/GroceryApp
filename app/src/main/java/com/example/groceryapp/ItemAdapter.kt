package com.example.groceryapp

import android.content.Context
import android.graphics.drawable.shapes.Shape
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.findViewTreeViewModelStoreOwner
import androidx.recyclerview.widget.RecyclerView


// The Adapter acts as a bridge between the data source and
// the RecyclerView UI element

class ItemAdapter(val itemsList:ArrayList<Item>):RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
         // called when rv needs a new ViewHolder Instance
        // inflating the layout for a single item and returning a new VH
        // viewGroup: is the parent view that the new view will be attached to after it's bound to it's data
        // viewType : in many cases you might have only on type of view used to distinguish bet. different view types

        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return ItemViewHolder(v)

    }

    override fun getItemCount(): Int {
        // returns the total number of items in the data set
        return itemsList.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        // bind data to a ViewHolder at a specific position
        holder.itemName.setText(itemsList[position].itemName)
        holder.itemDesc.setText(itemsList[position].itemDesc)
        holder.itemImage.setImageResource(itemsList[position].itemImage)

    }


    // ViewHolder: holding preferences to the views for a single
    // item in the RecyclerView
    // itemView: represents the view for a single item in RV

    inner class ItemViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        var itemImage:ImageView
        var itemName:TextView
        var itemDesc:TextView


        init {
            itemImage = itemView.findViewById(R.id.il_iv_item)
            itemName = itemView.findViewById(R.id.il_tv_itemName)
            itemDesc = itemView.findViewById(R.id.il_tv_itemDesc)

            itemView.setOnClickListener{
                Toast.makeText(itemView.context,"You Choose: ${itemsList[adapterPosition].itemName}",Toast.LENGTH_SHORT).show()

            }

        }
    }

}