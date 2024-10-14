package com.example.practico_3_moviles_1.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.practico_3_moviles_1.databinding.ProfileFragmentBinding

class ProfileImageAdapter(private val images: List<Int>) : RecyclerView.Adapter<ProfileImageAdapter.ImageViewHolder>() {

    class ImageViewHolder(private val binding: ProfileFragmentBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(imageResId: Int) {
            binding.imageView.setImageResource(imageResId)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val binding = ProfileFragmentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ImageViewHolder(binding)
    }

    override fun getItemCount(): Int = images.size

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bind(images[position])
    }
}
