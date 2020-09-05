package com.portfolio.advanceddi.ui

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.portfolio.advanceddi.model.Blog
import com.portfolio.advanceddi.repository.MainRepository
import com.portfolio.advanceddi.util.DataState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by paul on 9/2/2020 at 9:29 PM.
 */
class MainViewModel @ViewModelInject constructor(
    private val mainRepository: MainRepository,
    @Assisted private val savedStateHandle: SavedStateHandle
): ViewModel(){

    private val _dataState: MutableLiveData<DataState<List<Blog>>> = MutableLiveData()
    val dataState: LiveData<DataState<List<Blog>>>
        get () = _dataState

    @ExperimentalCoroutinesApi
    fun setStateEvent (mainStateEvent: MainStateEvent) {
        viewModelScope.launch {
            when (mainStateEvent){
                is MainStateEvent.GetBlogEvents -> {
                    mainRepository.getBlogs().onEach { dataState ->
                        _dataState.value = dataState
                    }.launchIn(viewModelScope)

                }

                is MainStateEvent.None -> {
                    //none
                }

            }
        }
    }

}

sealed class MainStateEvent {
    object GetBlogEvents: MainStateEvent()
    object None: MainStateEvent()
}