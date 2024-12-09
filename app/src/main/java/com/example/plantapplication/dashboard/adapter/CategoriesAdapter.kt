package com.example.plantapplication.dashboard.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.plantapplication.R
import com.example.plantapplication.databinding.CategoriesItemBinding
import com.example.plantapplication.repositories.entities.CategoriesItem

class CategoriesAdapter(
    private val context: Context,
    private val items: List<CategoriesItem>
) :
    RecyclerView.Adapter<CategoriesAdapter.CardViewHolder>() {

    // ViewHolder with ViewBinding
    class CardViewHolder(
        private val context: Context,
        private val binding: CategoriesItemBinding
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: CategoriesItem) {
            binding.infoText.text = item.title
            Glide.with(context) // Pass the context (Activity/Fragment context)
                .load(item.imageUrl) // URL of the image
                .placeholder(R.drawable.ediple_plants) // Optional placeholder
                .error(R.drawable.ediple_plants) // Optional error image
                .into(binding.backgroundImg) // Target ImageView
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val binding = CategoriesItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CardViewHolder(context, binding)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size
}