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

    lateinit var insuranceChip: Chip
    lateinit var filterChip: Chip
    var sidePadding = 0
    var sideHalfPadding = 0

    companion object {
        val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        main_sso.setOnClickListener { startActivity(Intent(this, SsoActivity::class.java))  }


        checkFbLoginStatus()

        insuranceChip = View.inflate(this, R.layout.facets_chip, null) as Chip
        filterChip = View.inflate(this, R.layout.facets_chip, null) as Chip

        sidePadding = resources.getDimensionPixelSize(R.dimen.app_global_side_padding)
        sideHalfPadding = resources.getDimensionPixelSize(R.dimen.app_global_side_half_half_padding)

        linear_layout.addView(insuranceChip)
        linear_layout.addView(filterChip)

        insuranceChip.text = "Cigna: Open Access Plan"
        filterChip.text = "more filters(2)"

        insuranceChip.layoutParams = getChipLayoutParams(sidePadding)
        filterChip.layoutParams = getChipLayoutParams(sideHalfPadding)
    }

    private fun checkFbLoginStatus() {
        val accessToken = AccessToken.getCurrentAccessToken()
        val isLoggedIn = accessToken != null && !accessToken.isExpired
        Log.e(TAG, "FB user loggedin = $isLoggedIn")

    }

    fun getChipLayoutParams(leftMar: Int) = LayoutParams(LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT).apply {
        setMargins(leftMar, 0, 0, 0)
    }
}
