package ru.netology.mysocialnetwork.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import ru.netology.mysocialnetwork.R
import ru.netology.mysocialnetwork.databinding.FeedFragmentEventsBinding

@AndroidEntryPoint
class EventsFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FeedFragmentEventsBinding.inflate(
            inflater,container,false
        )
        binding.add.setOnClickListener {
            //диалоговое окно если не зарегестрирован
           findNavController().navigate(R.id.action_navigation_events_to_new_event_fragment)
        }

        return binding.root
    }

}
