package com.example.filmsapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.filmsapp.R
import com.example.filmsapp.data.entity.Films
import com.example.filmsapp.databinding.CardDesignBinding
import com.example.filmsapp.databinding.FragmentMainpageBinding
import com.example.filmsapp.ui.fragment.MainpageFragmentDirections
import com.google.android.material.snackbar.Snackbar

class FilmsAdapter(var mContext : Context, var filmsList:List<Films>)
    : RecyclerView.Adapter<FilmsAdapter.cardDesignViewHolder>(){

    inner class cardDesignViewHolder(var design : CardDesignBinding) : RecyclerView.ViewHolder(design.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): cardDesignViewHolder {
        val binding : CardDesignBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext),R.layout.card_design,parent,false)
        return cardDesignViewHolder(binding)
    }


    override fun onBindViewHolder(holder: cardDesignViewHolder, position: Int) {
        val film = filmsList.get(position)
        val designHolder = holder.design

        designHolder.imageViewFilm.setImageResource(
            mContext.resources.getIdentifier(film.picture,"drawable",mContext.packageName))

       designHolder.filmObject = film

        designHolder.cardViewFilm.setOnClickListener {
            val pass = MainpageFragmentDirections.detailPass(film = film)
            Navigation.findNavController(it).navigate(pass)
        }
        designHolder.buttonCart.setOnClickListener {
            Snackbar.make(it,"${film.name} was adding to cart.", Snackbar.LENGTH_LONG).show()
        }

    }

    override fun getItemCount(): Int {
        return filmsList.size
    }
}