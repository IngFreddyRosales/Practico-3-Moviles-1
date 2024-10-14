@file:Suppress("UnusedEquals")

package com.example.practico_3_moviles_1.view

import LikedProfilesAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.practico_3_moviles_1.databinding.FragmentLikedProfilesBinding
import com.example.practico_3_moviles_1.databinding.FragmentProfileBinding
import com.example.practico_3_moviles_1.viewModel.ProfileViewModel

class LikedProfilesFragment : Fragment() {

    private lateinit var binding: FragmentLikedProfilesBinding
    private lateinit var viewModel: ProfileViewModel
    private lateinit var adapter: LikedProfilesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstance: Bundle?
    ): View?{
        binding = FragmentLikedProfilesBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(requireActivity()).get(ProfileViewModel::class.java)

        //adapter = LikedProfilesAdapter(viewModel.getLikedProfiles())
        adapter = LikedProfilesAdapter()
        binding.rvProfiles.layoutManager = LinearLayoutManager(requireContext())
        binding.rvProfiles.adapter = adapter

        viewModel.likedProfiles.observe(viewLifecycleOwner) { profiles ->
            adapter.submitList(profiles)  // Actualiza la lista de perfiles likeados en el RecyclerView
        }
        return binding.root
    }
}