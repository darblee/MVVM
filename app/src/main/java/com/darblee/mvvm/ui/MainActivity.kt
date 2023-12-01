package com.darblee.mvvm.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.darblee.mvvm.BuildConfig
import com.darblee.mvvm.Constants
import com.darblee.mvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewBinding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        val mainView = viewBinding.root
        setContentView(mainView)

        Log.i(Constants.app_tag, "Build time is " + BuildConfig.BUILD_TIME )
    }
}