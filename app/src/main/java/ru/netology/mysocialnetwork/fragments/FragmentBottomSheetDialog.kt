package ru.netology.mysocialnetwork.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint
import ru.netology.mysocialnetwork.R
import ru.netology.mysocialnetwork.databinding.FragmentBottomSheetDialogBinding
@AndroidEntryPoint
class FragmentBottomSheetDialog : BottomSheetDialogFragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentBottomSheetDialogBinding.inflate(inflater,container,false)

        return binding.root
    }


}
//пропали отступыю. тема разобрать.
