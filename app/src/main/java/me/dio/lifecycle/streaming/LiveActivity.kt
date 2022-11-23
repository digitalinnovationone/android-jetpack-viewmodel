package me.dio.lifecycle.streaming

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class LiveActivity : AppCompatActivity() {

    private val liveVideo = LiveVideo()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycle.addObserver(liveVideo)
    }
}