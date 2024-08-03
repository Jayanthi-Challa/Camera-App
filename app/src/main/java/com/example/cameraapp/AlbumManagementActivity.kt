package com.example.cameraapp  // Adjust the package name if necessary

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.cameraapp.data.Album
import com.example.cameraapp.viewmodel.PhotoViewModel
import android.widget.ArrayAdapter

class AlbumManagementActivity : AppCompatActivity() {
    private lateinit var viewModel: PhotoViewModel
    private lateinit var albumListView: ListView
    private lateinit var adapter: ArrayAdapter<Album>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_album_management)

        albumListView = findViewById(R.id.albumListView)
        viewModel = ViewModelProvider(this).get(PhotoViewModel::class.java)

        val albums = mutableListOf<Album>()
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, albums)
        albumListView.adapter = adapter

        viewModel.allAlbums.observe(this, Observer { albumList ->
            albumList?.let {
                adapter.clear()
                adapter.addAll(it)
            }
        })

        albumListView.setOnItemClickListener { _, _, position, _ ->
            val album = albums[position]
            // Handle album click (e.g., view or edit album)
        }
    }
}
