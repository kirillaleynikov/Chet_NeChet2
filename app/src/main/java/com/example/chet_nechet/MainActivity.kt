package com.example.chet_nechet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.chet_nechet.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.FrameComputer, ComputerFragment.newInstance())
            .commit()

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.FrameUser, UserFragment.newInstance())
            .commit()

    }
}