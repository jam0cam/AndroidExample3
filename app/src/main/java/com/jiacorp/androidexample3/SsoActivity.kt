package com.jiacorp.androidexample3

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginResult
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_sso.*
import android.content.Intent
import androidx.lifecycle.ViewModel


class SsoActivity : AppCompatActivity() {

    lateinit var callbackManager: CallbackManager

    companion object {
        val TAG = SsoActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sso)

        callbackManager = CallbackManager.Factory.create()
        sso_fb.setReadPermissions(listOf("email"))
        sso_fb.registerCallback(callbackManager, object : FacebookCallback<LoginResult> {
            override fun onSuccess(result: LoginResult?) {
                result?.let {
                    Log.e(TAG, "Success: ${Gson().toJson(it)}")
                }
            }

            override fun onCancel() {
                Log.e(TAG, "cancel")
            }

            override fun onError(error: FacebookException?) {
                Log.e(TAG, "error: ${error?.message}")
            }

        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        Log.e(TAG, "OnActivityResult")
        callbackManager.onActivityResult(requestCode, resultCode, data)
        super.onActivityResult(requestCode, resultCode, data)
    }

}

class TaskListViewModel(private val repository: MainActivity) : ViewModel() {

}

