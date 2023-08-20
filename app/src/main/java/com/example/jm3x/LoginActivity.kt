package com.example.jm3x

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class LoginActivity : AppCompatActivity() {
    var mFirebaseUser: FirebaseUser? = null
    var mFirebaseAuth: FirebaseAuth? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mFirebaseAuth = FirebaseAuth.getInstance()
        mFirebaseUser = FirebaseAuth.getInstance().currentUser
        if (mFirebaseUser != null) {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
        setContentView(R.layout.activity_login)
    }
}