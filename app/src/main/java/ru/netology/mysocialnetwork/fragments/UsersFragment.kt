package ru.netology.mysocialnetwork.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import ru.netology.mysocialnetwork.adapters.UserAdapter
import ru.netology.mysocialnetwork.databinding.FeedFragmentUsersBinding

@AndroidEntryPoint
class UsersFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FeedFragmentUsersBinding.inflate(
            inflater,container,false
        )
        val adapter = UserAdapter()
        binding.listUsers.adapter =adapter

       return binding.root
    }



}
