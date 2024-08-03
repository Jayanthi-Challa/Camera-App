package com.example.cameraapp.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PhotoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPhoto(photo: Photo)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAlbum(album: Album)

    @Query("SELECT * FROM albums ORDER BY timestamp DESC")
    fun getAllAlbums(): LiveData<List<Album>>

    @Query("SELECT * FROM photos WHERE albumId = :albumId")
    fun getPhotosForAlbum(albumId: Int): LiveData<List<Photo>>
}