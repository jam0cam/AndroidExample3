package com.jiacorp.androidexample3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import com.facebook.AccessToken



class MainActivity : AppCompatActivity() {

    companion object {
        val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        main_sso.setOnClickListener { startActivity(Intent(this, SsoActivity::class.java))  }


        checkFbLoginStatus()
    }

    private fun checkFbLoginStatus() {
        val accessToken = AccessToken.getCurrentAccessToken()
        val isLoggedIn = accessToken != null && !accessToken.isExpired
        Log.e(TAG, "FB user loggedin = $isLoggedIn")
    }
}
