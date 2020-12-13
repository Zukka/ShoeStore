package com.udacity.shoestore.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ShoeViewModel : ViewModel() {

    private val shoesList : MutableList<Shoe> = mutableListOf(
            Shoe("Model Air", "37.5","Nike", "Special edition for cricket players"),
            Shoe("Model Jet", "34.5","Adidas", "Pilots edition"),
            Shoe("Revenge Edition", "36.0","NoName", "Special edition for no ideas "),
            Shoe("Lol", "29.5","Zukka", "Special shoes for pumpkin lovers")
    )

    private var _showSnackBarError = MutableLiveData<Boolean>()
    val showSnackBarError: LiveData<Boolean>
        get() = _showSnackBarError

    fun eventSnackBarCompleted() {
        _showSnackBarError.value = false
    }

    private var _isLogged = MutableLiveData<Boolean>()
    val isLogged: LiveData<Boolean>
        get() = _isLogged

    fun logout()
    {
        _isLogged.value = false
    }
    fun login()
    {
        _isLogged.value = true
    }

    private var _shoe = MutableLiveData<MutableList<Shoe>>()
    val shoe: LiveData<MutableList<Shoe>>
        get() = _shoe

    init {
        buildShoeDataList()
    }

    private fun buildShoeDataList() {
        _shoe.value = shoesList
    }

    private val _save = MutableLiveData<Boolean>()
    val save: LiveData<Boolean>
        get() = _save

    fun onSave(shoe: Shoe?) {
        if (shoe != null && Utils.ShoeUtils.isShoeValid(shoe)) {
            _save.value = true
            shoesList.add(shoe)
            _shoe.value = shoesList
        } else {
            _showSnackBarError.value = true
        }
    }

    fun eventSaveComplete() {
        _save.value = false
    }

    private val _cancel = MutableLiveData<Boolean>()
    val cancel: LiveData<Boolean>
        get() = _cancel

    fun eventCancelComplete() {
        _cancel.value = false
    }
    fun onCancel() {
        _cancel.value = true
    }
}