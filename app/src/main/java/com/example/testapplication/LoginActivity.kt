package com.example.testapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.testapplication.databinding.ActivityLoginBinding
import com.example.testapplication.databinding.ActivityRegisterBinding

class LoginActivity : AppCompatActivity(){
    private lateinit var btn_login:Button
    private lateinit var btn_signup:Button
    private lateinit var btn_findpwd:Button

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        binding= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        btn_login=findViewById(R.id.login_btn)
        btn_signup=findViewById(R.id.sign_btn)
        btn_findpwd=findViewById(R.id.find_pwd_btn)

        binding.signBtn.setOnClickListener {
            val intent=Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        binding.loginBtn.setOnClickListener {

        }

        /*btn_signup.setOnClickListener{
            val intent=Intent(this, RegisterActivity::class.java)
            startActivity(intent)
            finish()
        }*/
    }
}