package com.jiacorp.androidexample3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_network.*

class NetworkActivity : AppCompatActivity(){

    val presenter = NetworkPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_network)

        btn_provider.setOnClickListener { presenter.providerCall() }
        btn_provider.setOnClickListener { presenter.reviewsCall() }
    }
}

