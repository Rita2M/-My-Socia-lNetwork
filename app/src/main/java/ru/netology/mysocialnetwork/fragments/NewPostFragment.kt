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
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.github.dhaval2404.imagepicker.ImagePicker
import dagger.hilt.android.AndroidEntryPoint
import ru.netology.mysocialnetwork.R
import ru.netology.mysocialnetwork.databinding.NewPostFragmentBinding
import ru.netology.mysocialnetwork.utils.Keyboard
import ru.netology.mysocialnetwork.viewModel.PostViewModel

@AndroidEntryPoint
class NewPostFragment:Fragment() {
    private val viewModel: PostViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = NewPostFragmentBinding.inflate(
            inflater,container,false
        )
        requireActivity().addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.save_menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean =
                when (menuItem.itemId) {
                    R.id.check -> {
                        val editedText = binding.edit.text.toString()
                        viewModel.changeContent(editedText)
                        viewModel.save()

                       Keyboard.hideKeyboard(requireView())


                        true
                    }

                    else -> false
                }


        }, viewLifecycleOwner)
        viewModel.postCreated.observe(viewLifecycleOwner) {
            viewModel.data
            findNavController().navigateUp()
        }

        binding.buttonImage.setOnClickListener {
            ImagePicker.Builder(this)
                .crop()
                .maxResultSize(2048, 2048)
               // .createIntent(photoResultContract::launch)

        }
        binding.buttonLocation.setOnClickListener {

        }

        binding.buttonPeople.setOnClickListener {

        }
        binding.buttonAttach.setOnClickListener {

        }

        return binding.root
    }
}
