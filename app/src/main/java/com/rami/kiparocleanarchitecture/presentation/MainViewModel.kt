package com.rami.kiparocleanarchitecture.presentation

import android.util.Log
import androidx.lifecycle.ViewModel

class MainViewModel(): ViewModel() {

    init {
        Log.e("COP", "VM created" )
    }

    override fun onCleared() {
        Log.e("COP", "VM created" )
        super.onCleared()
    }
}