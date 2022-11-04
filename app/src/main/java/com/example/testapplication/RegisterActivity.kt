package com.example.testapplication

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.Toast
import com.example.testapplication.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class RegisterActivity : AppCompatActivity(){
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

        //val Authnum = binding.AuthNum
        val Name = binding.Name
        val StudentID = binding.studentID
        val Email = binding.email
        val Password = binding.pwd
        val Password_check = binding.pwdCheck
        val Nickname = binding.nickname

        //var check = false


        S_btn = findViewById(R.id.submit_btn)
        A_btn = findViewById(R.id.Auth_button)

        binding.registerBtn.setOnClickListener {
            //학번이 비어있을 때 1
            if (TextUtils.isEmpty(StudentID.text.toString()))
                Toast.makeText(this, "학번을 입력해주세요", Toast.LENGTH_SHORT).show()

            //이메일이 비어있을 때 2
            else if (TextUtils.isEmpty(Email.text.toString()))
                Toast.makeText(this, "이메일을 입력해주세요", Toast.LENGTH_SHORT).show()

            //이름이 비어있을 때 3
            else if (TextUtils.isEmpty(Name.text.toString()))
                Toast.makeText(this, "이름을 입력해주세요", Toast.LENGTH_SHORT).show()

            //비밀번호가 같지 않을 때 4
            else if (!Password.text.toString().equals(Password_check.text.toString()))
                Toast.makeText(this, "비밀번호가 일치하지 않습니다", Toast.LENGTH_SHORT).show()

            //비밀번호 확인이 비어있을 때 5
            else if (TextUtils.isEmpty(Password_check.text.toString()))
                Toast.makeText(this, "비밀번호 확인을 입력해주세요", Toast.LENGTH_SHORT).show()

            //비밀번호가 비어있을 때
            else if (TextUtils.isEmpty(Password.text.toString()))
                Toast.makeText(this, "비밀번호 확인을 입력해주세요", Toast.LENGTH_SHORT).show()

            //닉네임이 비어있을 때
            else if (TextUtils.isEmpty(Nickname.text.toString()))
                Toast.makeText(this, "닉네임 확인을 입력해주세요", Toast.LENGTH_SHORT).show()

            //학번 형식이 맞지 않을 때
            else if (StudentID.length() != 10)
                Toast.makeText(this, "학번 형식이 맞지 않습니다", Toast.LENGTH_SHORT).show()
            /*else if (check != true)
                Toast.makeText(this, "인증번호가 확인되지 않았습니다", Toast.LENGTH_SHORT).show()*/
            else
                createAccount(binding.email.text.toString(), binding.pwd.text.toString())
        }

        binding.submitBtn.setOnClickListener {

        }

        binding.AuthButton.setOnClickListener {

        }
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