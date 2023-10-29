package com.example.mad_practical7_21012011120

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.MediaController
import android.widget.VideoView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        videoPlayer();
        var main:FloatingActionButton=findViewById(R.id.mainButton)
        main.setOnClickListener { Intent(this@MainActivity,YoutubeActivity::class.java).also { startActivity(it) } }
    }
    fun videoPlayer(){
        val mediaController= MediaController(this)
        val uri: Uri = Uri.parse("android.resource://"+packageName+"/"+R.raw.thestoryoflight)
        var v:VideoView=findViewById(R.id.videoView);
        v.setMediaController(mediaController)
        mediaController.setAnchorView(v);
        v.setVideoURI(uri);
        v.requestFocus();
        v.start();
    }
}