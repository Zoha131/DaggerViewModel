package io.github.zoha131.daggerviewmodel.viewmodel

import android.os.Bundle
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner
import io.github.zoha131.daggerviewmodel.MainActivity
import io.github.zoha131.daggerviewmodel.Repository.CloudRepository
import javax.inject.Inject

class OneViewModel(
    private val cloudRepository: CloudRepository,
    state: SavedStateHandle
) : ViewModel(){

    fun getName() = cloudRepository.getName()
}

class OneViewModelFactory @Inject constructor(
    owner: MainActivity ,

    // owner: SavedStateRegistryOwner ,
    // Here instead of SavedStateRegistryOwner I have
    // added MainActivity. This is for global viewmodel
    // scoped to activity. Feel free to add fragment
    // for fragment scoped viewmodel

    // defaultArgs: Bundle,
    // Here for default arg I have added null
    // You can easily add bundle from dagger
    // Using the @Named("tag") annotation

    private val repository: CloudRepository
)  : AbstractSavedStateViewModelFactory(owner, null) {
    override fun <T : ViewModel?> create(
        key: String,
        modelClass: Class<T>,
        handle: SavedStateHandle
    ): T {
        return OneViewModel(repository, handle) as T
    }
}