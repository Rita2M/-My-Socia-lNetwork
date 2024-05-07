package ru.netology.mysocialnetwork.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.netology.mysocialnetwork.R
import ru.netology.mysocialnetwork.databinding.CardEventBinding
import ru.netology.mysocialnetwork.dto.AttachmentType
import ru.netology.mysocialnetwork.dto.Event
import ru.netology.mysocialnetwork.dto.Post
import ru.netology.mysocialnetwork.utils.format

interface OnInteractionListenerEvent {
    fun onLike(event: Event) {}
    fun onEdit(event: Event) {}
    fun onRemove(event: Event) {}
    fun onShare(event: Event) {}
    fun onEvent(event: Event) {}
}
class EventAdapter(private val onInteractionListenerEvent:  OnInteractionListenerEvent): ListAdapter<Event,EventViewHolder>(EventDiffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
      val binding = CardEventBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return EventViewHolder(binding,onInteractionListenerEvent)
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        val event = getItem(position)
        holder.bind(event)
    }
}
class EventViewHolder(
    private val binding: CardEventBinding,
    private val onInteractionListenerEvent: OnInteractionListenerEvent
): RecyclerView.ViewHolder(binding.root){
fun bind(event: Event){
    binding.apply {
        nameAuthor.text = event.author
        published.text = event.published
        //type.text = event.type.toString()
        dataTime.text = event.datetime
        content.text = event.content
        like.isChecked= event.likedByMe
        like.text= format(event.likeOwnerIds.size)
        like.setOnClickListener {
            like.isChecked = !like.isChecked
            onInteractionListenerEvent.onLike(event)
        }
        participants.text = format(event.participantsIds.size)
        participants.isChecked = event.participatedByMe
        share.setOnClickListener {
            onInteractionListenerEvent.onShare(event)
        }
        val type = event.attachment?.type
        when (type) {
            AttachmentType.VIDEO -> {}
            AttachmentType.IMAGE -> {}
            AttachmentType.AUDIO -> {}

            else -> {}
        }



        if (!event.link.isNullOrBlank()){
            link.visibility = View.VISIBLE
        }else link.visibility = View.GONE
        menu.setOnClickListener {
            PopupMenu(it.context,it).apply {
                inflate(R.menu.menu_card)
                setOnMenuItemClickListener { item->
                    when(item.itemId){
                        R.id.edit->{
                            onInteractionListenerEvent.onEdit(event)
                            true
                        }
                        R.id.remove->{
                            onInteractionListenerEvent.onRemove(event)
                            true
                        }
                        else->false
                    }
                }
            }
        }

    }
}
}
object EventDiffCallback : DiffUtil.ItemCallback<Event>() {
    override fun areItemsTheSame(oldItem: Event, newItem: Event) = oldItem.id == newItem.id
    override fun areContentsTheSame(oldItem: Event, newItem: Event) = oldItem == newItem
}
