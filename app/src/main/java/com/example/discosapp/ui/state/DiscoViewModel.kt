package com.example.discosapp.ui.state

import android.app.Application
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.discosapp.data.AppDatabase
import com.example.discosapp.data.Disco
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import com.example.discosapp.data.startingDiscos

class DiscoViewModel(application: Application) :  AndroidViewModel(application) {
    private val discoDao = AppDatabase.getDatabase(application).discoDao();


    var showSuccessDialog = MutableStateFlow(false)
    var showErrorDialog = MutableStateFlow(false)
    var showExistsDialog = MutableStateFlow(false)
    var error = MutableStateFlow(false)

    val discos: Flow<List<Disco>> = discoDao.getAll()

    fun addDisco(disco: Disco) {
        viewModelScope.launch {
            discoDao.insert(disco)
        }
    }

    fun deleteDisco(disco: Disco) {
        viewModelScope.launch {
            discoDao.delete(disco)
        }
    }

    fun updateDisco(disco: Disco) {
        viewModelScope.launch {
            viewModelScope.launch {
                discoDao.update(disco)
            }
        }
    }

    fun setShowSuccessDialog(show: Boolean) {
        showSuccessDialog.value = show
    }

    fun setShowErrorDialog(show: Boolean) {
        showErrorDialog.value = show
    }

    fun setShowExistsDialog(show: Boolean) {
        showExistsDialog.value = show
    }



    fun setError(show: Boolean) {
        error.value = show
    }



    fun insertarDiscosPorDefecto() {
        viewModelScope.launch {
            startingDiscos.forEach { disco ->
                discoDao.insert(disco)
            }
        }
    }
}