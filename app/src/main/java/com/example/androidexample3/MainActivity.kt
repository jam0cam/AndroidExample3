package com.example.androidexample3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        main_sso.setOnClickListener { startActivity(Intent(this, SsoActivity::class.java))  }



        insuranceChip = View.inflate(this, R.layout.facets_chip, null) as Chip
        filterChip = View.inflate(this, R.layout.facets_chip, null) as Chip

        sidePadding = resources.getDimensionPixelSize(R.dimen.app_global_side_padding)
        sideHalfPadding = resources.getDimensionPixelSize(R.dimen.app_global_side_half_half_padding)

        linear_layout.addView(insuranceChip)
        linear_layout.addView(filterChip)

        insuranceChip.text = "Cigna: Open Access Plan"
        filterChip.text = "more filters(2)"

        insuranceChip.layoutParams = getChipLayoutParams(sidePadding!!)
        filterChip.layoutParams = getChipLayoutParams(sideHalfPadding!!)
    }


    fun getChipLayoutParams(leftMar: Int) = LayoutParams(LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT).apply {
        setMargins(leftMar, 0, 0, 0)
    }
}
