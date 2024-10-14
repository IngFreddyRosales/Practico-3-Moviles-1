package com.example.practico_3_moviles_1.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.practico_3_moviles_1.R
import com.example.practico_3_moviles_1.model.Profile

class ProfileViewModel : ViewModel() {


    private val _currentProfile = MutableLiveData<Profile>().apply { value = null }
    val currentProfile: LiveData<Profile> = _currentProfile

    private val _likedProfiles = MutableLiveData<List<Profile>>()
    val likedProfiles: LiveData<List<Profile>> = _likedProfiles

    private val profiles = listOf(
        Profile(
            images = listOf(
                R.drawable.sebs1,
                R.drawable.sebs2,
                R.drawable.sebs3
            ),
            name = "Sebastian Rengel"
        ),
        Profile(
            images = listOf(
                R.drawable.emma1,
                R.drawable.emma2,
                R.drawable.emma3
            ),
            name = "Emma Stone"
        ),
        Profile(
            images = listOf(
                R.drawable.pol1,
                R.drawable.pol2,
                R.drawable.pol3
            ),
            name = "Paul Amaya"
        ),
        Profile(
            images = listOf(
                R.drawable.thelma1,
                R.drawable.thelma2,
                R.drawable.thelma3
            ),
            name = "Thelma Velasco"
        ),
        Profile(
            images = listOf(
                R.drawable.anahi1,
                R.drawable.anahi2,
                R.drawable.anahi3
            ),
            name = "Anahi Zambrana"
        )
    )

    private var currentIndex = 0

    init{
        _currentProfile.value = profiles[currentIndex]
    }

    fun likeCurrentProfile(){
        _likedProfiles.value = _likedProfiles.value.orEmpty() + _currentProfile.value!!
        nextProfile()
    }

    fun dislikeCurrentProfile(){
        nextProfile()
    }

    fun nextProfile(){
        if(currentIndex < profiles.size - 1){
            currentIndex += 1
            _currentProfile.value = profiles[currentIndex]
        }else{
            _currentProfile.value = null
        }
    }


}