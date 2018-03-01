package com.diyetistan.diyetistanapp.ui

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.WindowManager
import android.widget.Toast
import com.diyetistan.diyetistanapp.R
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    val mAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_login)

        btn_login.setOnClickListener {
            login()
        }
        btn_register_account.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }


    }
    private fun login (){

        val email = et_email.text.toString()
        val password = et_password.text.toString()

        if(!email.isEmpty() && !password.isEmpty()){

            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this, OnCompleteListener { task ->

                if(task.isSuccessful){
                    Toast.makeText(this,"Giriş Başarılı",Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, MainActivity::class.java))
                }
                else{
                    Toast.makeText(this,"Hatalı Giriş.",Toast.LENGTH_SHORT).show()
                }

            })

        }
        else{
            Toast.makeText(this,"Lütfen Giriş Bilgilerinizi Kontrol Edin.",Toast.LENGTH_SHORT).show()
        }
    }

}
