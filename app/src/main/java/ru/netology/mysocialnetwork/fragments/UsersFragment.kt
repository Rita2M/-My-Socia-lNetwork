package ru.netology.mysocialnetwork.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.netology.mysocialnetwork.databinding.FeedFragmentUsersBinding


class UsersFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FeedFragmentUsersBinding.inflate(
            inflater,container,false
        )
       return binding.root
    }



}
