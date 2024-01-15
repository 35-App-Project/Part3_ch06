package com.choi.part3_ch06

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.choi.part3_ch06.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    private val adapter by lazy {
        ListAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater).apply {
            setContentView(root)
            recyclerView.adapter=adapter
        }

    }
}