package com.cgcreativesolutions.jetpackcomposetraining

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.cgcreativesolutions.jetpackcomposetraining.databinding.ActivityMainBinding

class MainActivity : FragmentActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, EventFragment())
                .commit()
        }
    }
}