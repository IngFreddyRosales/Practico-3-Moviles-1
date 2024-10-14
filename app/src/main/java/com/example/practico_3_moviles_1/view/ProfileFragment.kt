package com.example.practico_3_moviles_1.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.practico_3_moviles_1.R
import com.example.practico_3_moviles_1.databinding.FragmentProfileBinding
import com.example.practico_3_moviles_1.view.adapters.ProfileImageAdapter
import com.example.practico_3_moviles_1.viewModel.ProfileViewModel
import kotlinx.coroutines.selects.SelectInstance

class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding
    private lateinit var viewModel: ProfileViewModel
    private var currentImageIndex = 0

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstance: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(ProfileViewModel::class.java)

        viewModel.currentProfile.observe(viewLifecycleOwner) { profile ->
            if(profile != null){
                binding.lblName.text = profile.name
                val adapter = ProfileImageAdapter(profile.images)
                binding.viewPager.adapter = adapter
                currentImageIndex = 0
            }else{
                binding.lblName.text = "No hay más perfiles papu"
                binding.viewPager.adapter = null
            }
        }

        binding.likeButton.setOnClickListener { viewModel.likeCurrentProfile() }
        binding.dislikeButton.setOnClickListener { viewModel.dislikeCurrentProfile() }
        binding.listButton.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_Container, LikedProfilesFragment())
                .addToBackStack(null)
                .commit()
        }

        binding.viewPager.setOnTouchListener { _, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    binding.viewPager.performClick()
                }
                MotionEvent.ACTION_UP -> {
                    val nextImageIndex = (currentImageIndex + 1) % viewModel.currentProfile.value!!.images.size
                    binding.viewPager.currentItem = nextImageIndex
                    currentImageIndex = nextImageIndex
                }
            }
            true
        }
        return binding.root
    }

}