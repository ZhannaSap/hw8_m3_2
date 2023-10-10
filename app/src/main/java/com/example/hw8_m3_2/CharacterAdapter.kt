package com.example.hw8_m3_2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.hw8_m3_2.databinding.ItemCharacterBinding

class CharacterAdapter(
    private var characterList: ArrayList<Character>,
    private val onClick: (position:Int)->Unit
) :RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        return CharacterViewHolder(
            ItemCharacterBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = characterList.size

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(characterList[position])
    }

    inner class CharacterViewHolder(private var binding: ItemCharacterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Character) {
            itemView.setOnClickListener{
                onClick(adapterPosition)
            }
            binding.run {
                Glide.with(img).load(item.image).into(img)
                tvName.text = item.name
                tvPhrase.text = item.phrase
            }

        }
    }
}