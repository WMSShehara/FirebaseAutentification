package com.example.firebaseautentification

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.firebaseautentification.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        // Check if a user is currently signed in
        val currentUser = firebaseAuth.currentUser
        if (currentUser != null) {
            // If user is signed in, display the user's email with greeting
            binding.textViewUserEmail.text = "Hello, ${currentUser.email}"
        } else {
            // If user is not signed in, handle accordingly (redirect to sign-in activity, show login UI, etc.)
            binding.textViewUserEmail.text = "No user signed in"
        }
    }
}
