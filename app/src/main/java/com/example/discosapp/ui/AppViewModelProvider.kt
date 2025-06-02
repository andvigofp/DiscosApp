package com.example.discosapp.ui

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.discosapp.DiscosApplication
import com.example.discosapp.ui.state.DiscoViewModel

class DiscoViewModelFactory(private val application: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DiscoViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return DiscoViewModel(application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}

fun CreationExtras.discosApp(): DiscosApplication =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as DiscosApplication)