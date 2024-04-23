package ru.netology.mysocialnetwork.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.netology.mysocialnetwork.databinding.FeedFragmentPostsBinding

class PostsFragment :Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FeedFragmentPostsBinding.inflate(
            inflater,container,false
        )
        binding.add.setOnClickListener {
            findNavController()

        }
        return binding.root



    }
}
