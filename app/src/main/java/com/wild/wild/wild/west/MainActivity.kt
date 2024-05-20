package com.wild.wild.wild.west

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    companion object{
        var mediaPlayerWildWest: MediaPlayer? = null
        var pauseFragmentWildWest:Boolean=false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mediaPlayerWildWest = MediaPlayer.create(this, R.raw.background_wild_west)
        mediaPlayerWildWest?.isLooping = true
    }

    override fun onResume() {
        super.onResume()

        mediaPlayerWildWest?.start()
    }

    override fun onPause() {
        super.onPause()

        mediaPlayerWildWest?.pause()
    }

    override fun onDestroy() {
        super.onDestroy()

        mediaPlayerWildWest?.release()
    }
}