package com.example.testapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.Toast
import com.example.testapplication.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class RegisterActivity : AppCompatActivity(){
    private lateinit var R_btn: Button
    private lateinit var S_btn: Button
    private lateinit var A_btn:Button

    private lateinit var binding: ActivityRegisterBinding

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        binding= ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = Firebase.auth;


        S_btn = findViewById(R.id.submit_btn)
        R_btn = findViewById(R.id.register_btn)
        A_btn = findViewById(R.id.Auth_button)

        binding.registerBtn.setOnClickListener {
            createAccount(binding.email.text.toString(), binding.pwd.text.toString())
            //finish()
        }

        /*R_btn.setOnClickListener {
            createAccount()
        }*/
    }

    private fun createAccount(email: String, password: String) {
        if(email.isNotEmpty() && password.isNotEmpty()) {
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(
                            this, "계정 생성 완료.",
                            Toast.LENGTH_SHORT
                        ).show()
                        finish() // 가입창 종료
                    } else {
                        Toast.makeText(
                            this, "계정 생성 실패",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
        }
    }
}