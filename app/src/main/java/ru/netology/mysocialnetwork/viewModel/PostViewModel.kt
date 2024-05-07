package ru.netology.mysocialnetwork.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import ru.netology.mysocialnetwork.dto.Post
import ru.netology.mysocialnetwork.dto.UserPreview
import ru.netology.mysocialnetwork.repository.PostRepository
import ru.netology.mysocialnetwork.utils.SingleLiveEvent
import java.util.concurrent.Flow
import javax.inject.Inject

private val empty = Post(
    id = 0,
    authorId = 0,
    author = "",
    content = "",
    likedByMe = false,
    published = "",
    link = "",
    likeOwnerIds = emptySet(),
    mentionedMe = false,
    mentionIds = emptySet(),
   // users = emptyMap()
)

@HiltViewModel
class PostViewModel @Inject constructor(
    private val postRepository: PostRepository,
) : ViewModel() {
    val data: LiveData<List<Post>> = postRepository.data.asLiveData()
    private val _postCreated = SingleLiveEvent<Unit>()
    private val edited = MutableLiveData(empty)
    val postCreated: LiveData<Unit>
        get() = _postCreated

    fun save() {
       edited.value?.let {
           viewModelScope.launch {
           _postCreated.value = Unit
           postRepository.save(it)
       }
        }
    }
    fun changeContent(content: String) {
        val text = content.trim()
        if (edited.value?.content == text) {
            return
        }
        edited.value = edited.value?.copy(content = text)
    }


}
