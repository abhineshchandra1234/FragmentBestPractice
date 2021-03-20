package com.example.fragmentbestpractice

import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fragmentbestpractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val firstFragment =  FirstFragment()
        val secondFragment = SecondFragment()

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, firstFragment)
            commit()
        }

        binding.btnFragment1.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment, firstFragment)
//                addToBackStack(null) //to add stack
                commit()
            }
        }

        binding.btnFragment2.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment, secondFragment)
//                addToBackStack(null)
                commit()
            }
        }
    }
}