package com.example.artspaceapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var artworkArray: Array<Artwork>
    private lateinit var artworkImageView: ImageView
    private lateinit var artworkDescriptionTextView: TextView
    private lateinit var artworkAuthorTextView: TextView
    private var currentArtworkIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        artworkArray = arrayOf(
            Artwork("Whispers of the Wilderness", "Maya Chen(2022)", R.drawable.bear),
            Artwork("Majestic Flight", "Leo Stroud(2021)", R.drawable.eagle),
            Artwork("Cunning Shadows", "Aria Thompson(2023)", R.drawable.fox),
            Artwork("Harmony in Black and White", "Jin Park", R.drawable.panda),
            Artwork("Fierce Elegance", "Raj Patel", R.drawable.tiger)
        )

        artworkImageView = findViewById(R.id.artwork_image_view)
        artworkDescriptionTextView = findViewById(R.id.artwork_description_text_view)
        artworkAuthorTextView = findViewById(R.id.artwork_author_text_view)

        displayArtwork()

        findViewById<Button>(R.id.next_button).setOnClickListener {
            currentArtworkIndex = (currentArtworkIndex + 1) % artworkArray.size
            displayArtwork()
        }

        findViewById<Button>(R.id.previous_button).setOnClickListener {
            currentArtworkIndex = (currentArtworkIndex - 1 + artworkArray.size) % artworkArray.size
            displayArtwork()
        }
    }

    private fun displayArtwork() {
        val currentArtwork = artworkArray[currentArtworkIndex]
        artworkImageView.setImageResource(currentArtwork.imageResource)
        artworkDescriptionTextView.text = currentArtwork.description
        artworkAuthorTextView.text = currentArtwork.author
    }
}

data class Artwork(val description: String, val author: String, val imageResource: Int)