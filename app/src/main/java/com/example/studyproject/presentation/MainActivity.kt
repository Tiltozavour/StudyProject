package com.example.studyproject.presentation

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.studyproject.R
import com.example.studyproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val viewModelCoroutines by lazy {
        ViewModelProvider(this)[Coroutines::class.java]
    }

    private val viewModelCoroutinesException by lazy {
        ViewModelProvider(this)[CoroutinesException::class.java]
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.main)
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        /* with(viewModelCoroutines){
             getAll()
             getAcyncOrLaunch()
             getStream()
         }*/
        /*   with(viewModelCoroutinesException){
               //ordinaryFun()
              smtErrorMethod()
           }*/



    }
}