package com.jiacorp.androidexample3

import android.animation.Animator
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.net.sip.SipSession
import android.os.Bundle
import android.util.Log
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.core.animation.addListener
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_progress.*
import java.util.concurrent.TimeUnit

class ProgressActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_progress)

        prog_animate_intervals.setOnClickListener { animateIntervals() }
        prog_animate_once.setOnClickListener { animateOnce() }
        prog_animate_once_change_color.setOnClickListener { animateOnceChangeColor() }
    }

    private fun animateOnceChangeColor() {
        prog_progress_bar.progress = 0
        ObjectAnimator.ofInt(prog_progress_bar, "progress", 75)
            .apply {
                duration = 1000
                interpolator = AccelerateDecelerateInterpolator()
                addUpdateListener {
                     if ((it.animatedValue as Int) < 50) {
                         Log.e("JIA", "${it.animatedValue} setting to orange")
                         prog_progress_bar.progressDrawable = getDrawable(R.drawable.orange_progress)
                     } else {
                         Log.e("JIA", "${it.animatedValue} setting to green")
                         prog_progress_bar.progressDrawable = getDrawable(R.drawable.green_progress)
                     }

                }
                start()
            }
    }

    private fun animateOnce() {
        prog_progress_bar.progress = 0
        ObjectAnimator.ofInt(prog_progress_bar, "progress", 75)
            .apply {
                duration = 500
                interpolator = AccelerateDecelerateInterpolator()
                start()
            }
    }

    @SuppressLint("CheckResult")
    private fun animateIntervals() {
        prog_progress_bar.progress = 0

        Observable.interval(0, 500, TimeUnit.MILLISECONDS)
            .take(6)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {

                Log.e("JIA", "emitted $it")
                ObjectAnimator.ofInt(prog_progress_bar, "progress", (it * 20).toInt())
                    .apply {
                        duration = 300
                        interpolator = AccelerateDecelerateInterpolator()
                        start()
                    }
            }
    }
}