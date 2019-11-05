package com.jiacorp.androidexample3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.LinearLayout.*
import kotlinx.android.synthetic.main.activity_main.*
import com.facebook.AccessToken
import com.google.android.material.chip.Chip

class MainActivity : AppCompatActivity() {
    companion object {
        val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        main_sso.setOnClickListener { startActivity(Intent(this, SsoActivity::class.java))  }
        main_morphing_toolbar.setOnClickListener { startActivity(Intent(this, MorphingToolbarActivity::class.java))  }
        main_progress.setOnClickListener { startActivity(Intent(this, ProgressActivity::class.java))  }
    }

}
