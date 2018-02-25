package com.diyetistan.diyetistanapp.ui

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.diyetistan.diyetistanapp.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    val mAuth = FirebaseAuth.getInstance()
    lateinit var mDatabase : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        mDatabase =FirebaseDatabase.getInstance().getReference("Names")

        btn_register_createaccount.setOnClickListener {

            register()

        }
    }

    private fun register(){

        var email = et_emailregister.text.toString()
        var password = et_passwordregister.text.toString()
        var name = et_nameregister.text.toString()

        if(!name.isEmpty() && !password.isEmpty() && !email.isEmpty()){

            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener { task ->
                if(task.isSuccessful){
                    val user = mAuth.currentUser
                    val uid = user!!.uid
                    mDatabase.child(uid).child("Name").setValue(name)
                    Toast.makeText(this,"Kayıt Başarılı !", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, MainActivity::class.java))

                }
                else{
                    Toast.makeText(this,"Kayıt Başarısız !", Toast.LENGTH_SHORT).show()
                }
            }

        }
        else{
            Toast.makeText(this,"Lütfen Kayıt Bilgilerinizi Kontrol Edin.",Toast.LENGTH_SHORT).show()
        }

    }
}
