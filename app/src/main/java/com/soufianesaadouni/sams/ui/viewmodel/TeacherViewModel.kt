package com.soufianesaadouni.sams.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase

class TeacherViewModel : ViewModel() {
    private val auth = Firebase.auth
    private val db = FirebaseFirestore.getInstance()
    private val collectionPath = "Teachers"

    fun isUserSignedIn(): Boolean {
        return auth.currentUser != null
    }

    fun createTeacher(fullName: String, email: String, password: String): Task<AuthResult> {
        return auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
            if (it.isSuccessful) {
                val user = auth.currentUser
                val teacherData = hashMapOf(
                    "name" to fullName,
                    "email" to email
                )

                if (user != null) {
                    db.collection(collectionPath)
                        .document(user.uid)
                        .set(teacherData)
                        .addOnSuccessListener { }
                        .addOnFailureListener { }
                }
            } else {
                //TODO handle failure
            }
        }
    }

    fun signIn(email: String, password: String): Task<AuthResult> {
        return auth.signInWithEmailAndPassword(email, password)
    }

    fun signOut() {
        auth.signOut()
    }
}