package ru.netology.mysocialnetwork.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import ru.netology.mysocialnetwork.R
import ru.netology.mysocialnetwork.adapters.OnInteractionListener
import ru.netology.mysocialnetwork.adapters.PostAdapter
import ru.netology.mysocialnetwork.databinding.FeedFragmentPostsBinding
import ru.netology.mysocialnetwork.dto.Post
@AndroidEntryPoint
class PostsFragment :Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FeedFragmentPostsBinding.inflate(
            inflater,container,false
        )
        val adapter = PostAdapter(object : OnInteractionListener{
            override fun onLike(post: Post) {
                super.onLike(post)
            }

            override fun onShare(post: Post) {
                super.onShare(post)
            }

            override fun onEdit(post: Post) {
                super.onEdit(post)
            }

            override fun onRemove(post: Post) {
                super.onRemove(post)
            }

            override fun onPost(post: Post) {
                super.onPost(post)
            }
        })
        binding.listPost.adapter = adapter
        binding.add.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_posts_to_new_post_fragment)

        }

        return binding.root



    }
}
