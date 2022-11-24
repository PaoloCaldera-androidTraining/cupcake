package com.example.cupcake

import android.util.Log
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.cupcake.model.OrderViewModel
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class ViewModelTests {

    // LiveData objects cannot access the main thread, which is the UI thread
    // Explicitly state that LiveData objects do not access the main thread with the test rule
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Test
    fun quantity_twelve_cupcakes() {
        val viewModel = OrderViewModel()
        viewModel.setQuantity(12)
        assertEquals(12, viewModel.quantity.value)
    }

    @Test

    fun price_twelve_cupcakes() {
        val viewModel = OrderViewModel()
        // LiveData objects must be observed in order to record any change in its value
        viewModel.price.observeForever {}
        viewModel.setQuantity(12)
        assertEquals("$24.00", viewModel.price.value)

        /* TODO: why the test method is not successful? */
    }
}