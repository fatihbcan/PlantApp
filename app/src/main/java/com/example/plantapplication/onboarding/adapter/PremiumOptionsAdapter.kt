package com.example.plantapplication.onboarding.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.plantapplication.R
import com.example.plantapplication.databinding.PremiumOptionsItemBinding
import com.example.plantapplication.onboarding.models.PremiumOptionModel

class PremiumOptionsAdapter(
    private val context: Context,
    private val items: ArrayList<PremiumOptionModel>,
    private val onItemClick: (PremiumOptionModel) -> Unit
) :
    RecyclerView.Adapter<PremiumOptionsAdapter.PremiumOptionsViewHolder>() {

    // ViewHolder with ViewBinding
    class PremiumOptionsViewHolder(
        private val context: Context,
        private val binding: PremiumOptionsItemBinding
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: PremiumOptionModel, onItemClick: (PremiumOptionModel) -> Unit) {
            binding.title.text = context.getString(item.title)
            binding.subtitle.text = context.getString(item.subtitle)
            binding.saveOption.visibility = if (item.isFeatured) View.VISIBLE else View.GONE
            binding.root.strokeColor = if (item.isFeatured) ContextCompat.getColor(context, R.color.premium_options_stroke_active) else ContextCompat.getColor(context, R.color.premium_options_stroke_inactive)
            binding.radiobutton.isChecked = item.isChecked
            binding.root.setOnClickListener {
                onItemClick(item)
            }
            binding.radiobutton.setOnClickListener {
                onItemClick(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PremiumOptionsViewHolder {
        val binding = PremiumOptionsItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return PremiumOptionsViewHolder(context, binding)
    }

    override fun onBindViewHolder(holder: PremiumOptionsViewHolder, position: Int) {
        holder.bind(items[position], onItemClick)
    }

    override fun getItemCount(): Int = items.size
}