package com.example.cupcake.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.text.SimpleDateFormat
import java.util.*

class PickupViewModel : ViewModel() {

    /* ********** UI variables ********** */

    private val _dateOptions = MutableLiveData<List<String>>()
    val dateOptions: LiveData<List<String>> get() = _dateOptions

    /* ********** UI variables ********** */

    init {
        getPickupOptions()
    }


    private fun getPickupOptions() {
        val options = mutableListOf<String>()
        val formatter = SimpleDateFormat("EEE d MMM", Locale.getDefault())
        val calendar = Calendar.getInstance()

        repeat(4) {
            options.add(formatter.format(calendar.time))
            calendar.add(Calendar.DATE, 1)
        }

        _dateOptions.value = options
    }
}