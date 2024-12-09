package com.example.plantapplication.dashboard.adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.plantapplication.R
import com.example.plantapplication.databinding.CategoriesItemBinding
import com.example.plantapplication.databinding.DashboardGetStartCardBinding
import com.example.plantapplication.repositories.entities.CategoriesItem
import com.example.plantapplication.repositories.entities.QuestionsItem

class QuestionsAdapter (
    private val context: Context,
    private val items: List<QuestionsItem>
) :
    RecyclerView.Adapter<QuestionsAdapter.QuestionsCardViewHolder>() {

    // ViewHolder with ViewBinding
    class QuestionsCardViewHolder(
        private val context: Context,
        private val binding: DashboardGetStartCardBinding
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: QuestionsItem) {
            binding.title.text = item.title
            binding.root.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(item.redirectUrl))
                context.startActivity(intent)
            }
            Glide.with(context) // Pass the context (Activity/Fragment context)
                .load(item.imageUrl) // URL of the image
                .placeholder(R.drawable.scan_plant_bg) // Optional placeholder
                .error(R.drawable.scan_plant_bg) // Optional error image
                .into(binding.background) // Target ImageView
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionsCardViewHolder {
        val binding = DashboardGetStartCardBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return QuestionsCardViewHolder(context, binding)
    }

    override fun onBindViewHolder(holder: QuestionsCardViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size
}