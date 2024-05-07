package ru.netology.mysocialnetwork.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import ru.netology.mysocialnetwork.R
import ru.netology.mysocialnetwork.databinding.NewEventFragmentBinding
import ru.netology.mysocialnetwork.utils.Keyboard

@AndroidEntryPoint
class NewEventFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = NewEventFragmentBinding.inflate(
            inflater, container, false
        )
        requireActivity().addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.save_menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean =
                when (menuItem.itemId) {
                    R.id.check -> {
                        Keyboard.hideKeyboard(requireView())


                        true
                    }

                    else -> false
                }


        }, viewLifecycleOwner)
        binding.included.buttonLocation.setOnClickListener {

        }
        binding.included.buttonImage.setOnClickListener {

        }
        binding.included.buttonPeople.setOnClickListener {

        }
        binding.included.buttonAttach.setOnClickListener {

        }
        binding.add.setOnClickListener {

           val  dialog = FragmentBottomSheetDialog()
            dialog.show(parentFragmentManager, "uu")
        }
        return binding.root
    }
}
