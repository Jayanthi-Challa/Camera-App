package com.example.cameraapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cameraapp.data.Photo
import com.example.cameraapp.data.Album
import com.example.cameraapp.data.PhotoRepository
import com.example.cameraapp.data.AppDatabase
import kotlinx.coroutines.launch

class PhotoViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: PhotoRepository
    val allAlbums: LiveData<List<Album>>

    init {
        val photoDao = AppDatabase.getDatabase(application).photoDao()
        repository = PhotoRepository(photoDao)
        allAlbums = repository.allAlbums
    }

    fun insert(photo: Photo) = viewModelScope.launch {
        repository.insert(photo)
    }

    fun insert(album: Album) = viewModelScope.launch {
        repository.insert(album)
    }
}