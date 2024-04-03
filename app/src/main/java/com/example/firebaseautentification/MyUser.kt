package com.example.firebaseautentification

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore

val fireStore = FirebaseFirestore.getInstance()

val user = hashMapOf<String, Any>(
    "fanme" to "John",
    "lname" to "Doe",
)

val userCollection = fireStore.collection("users")
    .document("admin")
    .set(user)
    .addOnSuccessListener {
        d -> Log.i("***", "User created")
    }
    .addOnFailureListener {
        e -> Log.e("***", "Error creating user", e)
    }