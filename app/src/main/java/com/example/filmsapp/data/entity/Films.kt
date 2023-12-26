package com.example.filmsapp.data.entity

import java.io.Serializable

class Films(var id : Int,
            var name : String,
            var picture : String,
                        var price : Int): Serializable {
}