package com.example.plantapplication.onboarding.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.plantapplication.databinding.PaywallFeaturesCardBinding
import com.example.plantapplication.onboarding.models.PaywallFeaturedItems

class PaywallFeaturedAdapter(
    private val context: Context,
    private val items: List<PaywallFeaturedItems>
) :
    RecyclerView.Adapter<PaywallFeaturedAdapter.PremiumOptionsViewHolder>() {

    // ViewHolder with ViewBinding
    class PremiumOptionsViewHolder(
        private val context: Context,
        private val binding: PaywallFeaturesCardBinding
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: PaywallFeaturedItems) {
            binding.title.text = context.getString(item.title)
            binding.subtitle.text = context.getString(item.subtitle)
            binding.icon.setImageResource(item.icon)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PremiumOptionsViewHolder {
        val binding = PaywallFeaturesCardBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return PremiumOptionsViewHolder(context, binding)
    }

    override fun onBindViewHolder(holder: PremiumOptionsViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size
}