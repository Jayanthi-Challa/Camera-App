package com.example.cameraapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "photos")
data class Photo(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val albumId: Int,
    val photoPath: String,
    val timestamp: Long
)