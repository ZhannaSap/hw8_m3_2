package com.example.hw8_m3_2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.hw8_m3_2.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding
    private val characterList = arrayListOf(
        Character("https://nucarnival.com/static/d21063a7d97ef6eec3918e36066bf4f0/517e6/yakumo_face1.webp", "Yakumo", "I don't want to... be all alone again... I want to become stronger... so that I can protect Mr Eiden and the others..."),
        Character("https://nucarnival.com/static/7d3e6866d4ec1f9806e3676b6a3f387d/517e6/kuya_face1.webp", "Kuya", "Hehe... I wonder what special tricks you'll have to please me in the future. I'll be waiting most expectantly."),
        Character("https://nucarnival.com/static/0bdb761037ebb4ed631d9dd8ed924346/517e6/edmond_face1.webp", "Edmond", "I swear on my honor... to pledge my life to the protection of the kingdom."),
        Character("https://nucarnival.com/static/2dd0f52450438cbaaa55631f2847b2ea/517e6/olivine_face1.webp", "Olivine", "Worship me...? That's a bit of an exaggeration... This is just proof of everyone's undying faith in the God of Klein."),
        Character("https://nucarnival.com/static/905645bc019636031f3709040a04872c/517e6/quincy_face1.webp", "Quincy", "... It would have been much less troublesome if you'd have just gone home."),
        Character("https://nucarnival.com/static/02dc607d76861a24e2a55e5041e19055/517e6/garu_face2.webp", "Garu/Karu", "If I successfully accomplish my duties, I'll get lots of praise and tasty food, right?"),
        Character("https://nucarnival.com/static/ac68dc4745efbcc84168efa478d41029/517e6/blade_face1.webp", "Blade", "La la la~ La da da~♪ I just found tons of super cute items! What an amazing day!♡"),
        Character("https://nucarnival.com/static/2febf16fd7d7c57509c6d016b0bf7098/517e6/dante_face2.webp", "Dante", "... Do you enjoy infuriating me? I will not let anyone who challenges my authority off lightly."),
        Character("https://nucarnival.com/static/bef99182c8fb610630721155a2778a9a/517e6/rei_face1.webp", "Rei", "I can see your movements clear as day.")
        )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = CharacterAdapter(characterList, this::onClick)
        binding.recyclerView.adapter = adapter
    }
    fun onClick(position: Int){
        val imgOfCharacter = characterList[position].image
        val nameOfCharacter = characterList[position].name
        val phraseOfCharacter = characterList[position].phrase
        val bundle = Bundle()
        bundle.putString("image", imgOfCharacter)
        bundle.putString("name", nameOfCharacter)
        bundle.putString("phrase", phraseOfCharacter)

        val secondFragment = SecondFragment()
        secondFragment.arguments = bundle
        findNavController().navigate(R.id.secondFragment, bundle)
    }
}