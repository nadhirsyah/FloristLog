package id.ac.ui.cs.mobileprogramming.nadhirsyah.floristlog.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import id.ac.ui.cs.mobileprogramming.nadhirsyah.floristlog.repository.AboutRepository

class AboutViewModelFactory(
    private val repository: AboutRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return AboutViewModel(repository) as T
    }
}