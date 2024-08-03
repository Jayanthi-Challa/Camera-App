package com.example.cameraapp.data

import androidx.lifecycle.LiveData
import androidx.annotation.WorkerThread

class PhotoRepository(private val photoDao: PhotoDao) {
    val allAlbums: LiveData<List<Album>> = photoDao.getAllAlbums()

    @WorkerThread
    suspend fun insert(photo: Photo) {
        photoDao.insertPhoto(photo)
    }

    @WorkerThread
    suspend fun insert(album: Album) {
        photoDao.insertAlbum(album)
    }
}