package com.example.cupcake.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import java.text.NumberFormat
import java.util.*

class OrderViewModel : ViewModel() {

    /* ********** UI variables ********** */

    private val _quantity = MutableLiveData<Int>()
    val quantity: LiveData<Int> get() = _quantity

    private val _flavor = MutableLiveData<String>()
    val flavor: LiveData<String> get() = _flavor

    private val _date = MutableLiveData<String>()
    val date: LiveData<String> get() = _date

    private val _price = MutableLiveData<Double>()
    val price: LiveData<String> get() = Transformations.map(_price) {
        NumberFormat.getCurrencyInstance(Locale.getDefault()).format(it)
    }

    /* ********** UI variables ********** */


    fun setQuantity(numberOfCupcakes: Int) {
        _quantity.value = numberOfCupcakes
    }

    fun setFlavor(desiredFlavor: String) {
        _flavor.value = desiredFlavor
    }

    fun setDate(pickupDate: String) {
        _date.value = pickupDate
    }
}