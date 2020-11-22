package com.udacity.shoestore.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeViewModel : ViewModel() {

    private var _shoe = MutableLiveData<List<Shoe>>()

    val shoe: LiveData<List<Shoe>>
        get() = _shoe


    private fun buildShoeDataList() {
        _shoe.value
    }


}