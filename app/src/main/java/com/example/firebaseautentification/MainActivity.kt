package com.example.firebaseautentification

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.firebaseautentification.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var fireStore: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()
        fireStore = FirebaseFirestore.getInstance()

        // Check if a user is currently signed in
        val currentUser = firebaseAuth.currentUser
     if (currentUser != null){
         val uid = currentUser.uid
         fireStore.collection("users")
             .document(uid)
             .get()
             .addOnCompleteListener{
                 getUserTask ->
                    if (getUserTask.isSuccessful){
                        val userDocument = getUserTask.result
                        if (userDocument != null){
                            val username = userDocument.getString("username")
                            binding.textViewUserName.text = "Welcome $username"
                        }
             }
     }
    }
    }
}


