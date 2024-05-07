package ru.netology.mysocialnetwork.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.PopupMenu
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.netology.mysocialnetwork.R
import ru.netology.mysocialnetwork.databinding.CardPostBinding
import ru.netology.mysocialnetwork.dto.AttachmentType
import ru.netology.mysocialnetwork.dto.Post
import ru.netology.mysocialnetwork.utils.format

interface OnInteractionListener {
    fun onLike(post: Post) {}
    fun onEdit(post: Post) {}
    fun onRemove(post: Post) {}
    fun onShare(post: Post) {}
    fun onPost(post: Post) {}
}

class PostAdapter(private val onInteractionListener: OnInteractionListener) : ListAdapter<Post, PostViewHolder>(PostDiffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val binding = CardPostBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostViewHolder(binding, onInteractionListener )
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        val post = getItem(position)
        holder.bind(post)
    }
}

class PostViewHolder(
    private val binding: CardPostBinding,
    private val onInteractionListener: OnInteractionListener
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(post: Post) {
        binding.apply {

            nameAuthor.text = post.author
            published.text = post.published
            if (!post.link.isNullOrBlank()){
                link.visibility = View.VISIBLE
            }else link.visibility = View.GONE
            like.isChecked = post.likedByMe
            like.text = format(post.likeOwnerIds.size)
            like.setOnClickListener {
                like.isChecked = !like.isChecked
                onInteractionListener.onLike(post)
            }
            val type = post.attachment?.type
            when (type) {
                AttachmentType.VIDEO -> {}
                AttachmentType.IMAGE -> {}
                AttachmentType.AUDIO -> {}

                else -> {}
            }
            share.setOnClickListener {
                onInteractionListener.onShare(post)
            }
            root.setOnClickListener {
                onInteractionListener.onPost(post)
            }


            menu.setOnClickListener {
                PopupMenu(it.context, it).apply {
                    inflate(R.menu.menu_card)
                    setOnMenuItemClickListener { item ->
                        when (item.itemId) {
                            R.id.edit -> {
                                onInteractionListener.onEdit(post)
                                true
                            }

                            R.id.remove -> {
                                onInteractionListener.onRemove(post)
                                true
                            }

                            else -> false
                        }
                    }
                }.show()
            }


        }

    }

}

object PostDiffCallback : DiffUtil.ItemCallback<Post>() {
    override fun areItemsTheSame(oldItem: Post, newItem: Post) = oldItem.id == newItem.id
    override fun areContentsTheSame(oldItem: Post, newItem: Post) = oldItem == newItem
}
