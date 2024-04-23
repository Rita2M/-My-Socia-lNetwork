package ru.netology.mysocialnetwork.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import ru.netology.mysocialnetwork.databinding.FeedFragmentEventsBinding


class EventsFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FeedFragmentEventsBinding.inflate(
            inflater,container,false
        )

        return binding.root
    }

}
