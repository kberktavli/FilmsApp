package com.example.filmsapp.data.repo

import com.example.filmsapp.data.datasource.FilmsDataSource
import com.example.filmsapp.data.entity.Films
import javax.inject.Inject

class FilmsRepository @Inject constructor(var fds : FilmsDataSource) {
    suspend fun filmsLoad() : List<Films> = fds.filmsLoad()
}