package com.example.testapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
//import com.bumptech.glide.Glide
import com.example.testapplication.databinding.ActivityLoginBinding
import com.example.testapplication.databinding.ActivityMainPageBinding
import com.google.firebase.auth.FirebaseAuth
//import com.google.firebase.database.*
import com.google.firebase.ktx.Firebase
//import kotlinx.android.synthetic.main.activity_main_page.*
//import kotlinx.android.synthetic.main.row_chat.view.*
import kotlin.reflect.typeOf


class MainPage : AppCompatActivity() {

    private lateinit var binding: ActivityMainPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_page)
        binding = ActivityMainPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}