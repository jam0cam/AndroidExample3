package com.jiacorp.androidexample3

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_morphing_toolbar.*

class MorphingToolbarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_morphing_toolbar)


        start_animation.setOnClickListener{
            Log.e("JIA", "onClick")

            if (motion_layout.currentState == motion_layout.endState) {
                motion_layout.transitionToStart()
            } else {
                motion_layout.transitionToEnd()
            }

        }
    }
}