package com.example.filmsapp.data.datasource

import com.example.filmsapp.data.entity.Films
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FilmsDataSource {
    suspend fun filmsLoad() : List<Films> =
        withContext(Dispatchers.IO){
            val filmList = ArrayList<Films>()
            val f1 = Films(1, "Django", "django", 24)
            val f2 = Films(2, "Interstellar", "interstellar", 32)
            val f3 = Films(3, "Inception", "inception", 16)
            val f4 = Films(4, "The Hateful Eight", "thehatefuleight", 28)
            val f5 = Films(5, "The Pianist", "thepianist", 18)
            val f6 = Films(6, "Anadoluda", "anadoluda", 10)
            filmList.add(f1)
            filmList.add(f2)
            filmList.add(f3)
            filmList.add(f4)
            filmList.add(f5)
            filmList.add(f6)

            return@withContext filmList
        }



}