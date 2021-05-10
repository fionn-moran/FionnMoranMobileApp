package com.example.fionnmoranmobileapp.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.example.fionnmoranmobileapp.R
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import kotlinx.android.synthetic.main.aboutus_activity.*
import kotlinx.android.synthetic.main.activity_booking.*
import java.net.URL
import java.util.regex.Pattern

class AboutUsActivity : YouTubeBaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.aboutus_activity)

        initializePlayer(getYoutubeVideoIdFromURL("https://www.youtube.com/watch?v=Zo3cCyhBfko")!!)

        btnReturn1.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun initializePlayer(videoId: String) {
        ytPlayer.initialize(getString(R.string.ytAPI),
            object : YouTubePlayer.OnInitializedListener {
                override fun onInitializationSuccess(
                    p0: YouTubePlayer.Provider?,
                    p1: YouTubePlayer?,
                    p2: Boolean
                ) {
                    p1!!.loadVideo(videoId)
                    p1.play()
                }

                override fun onInitializationFailure(
                    p0: YouTubePlayer.Provider?,
                    p1: YouTubeInitializationResult?
                ) {
                    Toast.makeText(applicationContext, "error occured", Toast.LENGTH_LONG).show()
                }
            })
    }

    fun getYoutubeVideoIdFromURL(inURL: String): String? {
        if (inURL.toLowerCase().contains("youtu.be")) {
            return inURL.substring(inURL.lastIndexOf("/")+1)
        }
        val pattern = "(?<=watch\\?v=|/videos/|embed\\/)[^#\\&\\?]*"
        val compiledPattern = Pattern.compile(pattern)
        val matcher = compiledPattern.matcher(inURL)
        return if (matcher.find()) {
            matcher.group()
        } else null
    }
}