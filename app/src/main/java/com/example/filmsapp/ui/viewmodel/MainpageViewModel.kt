package com.example.filmsapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.filmsapp.data.datasource.FilmsDataSource
import com.example.filmsapp.data.entity.Films
import com.example.filmsapp.data.repo.FilmsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class MainpageViewModel @Inject constructor(var frepo : FilmsRepository) : ViewModel() {
    var filmsList = MutableLiveData<List<Films>>()

    init {
        filmsLoad()
    }

    fun filmsLoad() {
        CoroutineScope(Dispatchers.Main).launch {
            filmsList.value = frepo.filmsLoad()
        }
    }
}