package com.udacity.shoestore.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeViewModel : ViewModel() {

    val shoesList : List<Shoe> = listOf(
            Shoe("Model Air", 37.5,"Nike", "Special edition for cricket players", mutableListOf("")),
            Shoe("Model Jet", 34.5,"Adidas", "Pilots edition", mutableListOf("")),
            Shoe("Revenge Edition", 36.0,"NoName", "Special edition for no ideas ", mutableListOf("")),
            Shoe("Lol", 29.5,"Zukka", "Special shoes for pumpkin lovers", mutableListOf(""))
    )

    private var _shoe = MutableLiveData<List<Shoe>>()

    val shoe: LiveData<List<Shoe>>
        get() = _shoe

    init {
        buildShoeDataList()
    }

    private fun buildShoeDataList() {
        _shoe.value = shoesList
    }


}