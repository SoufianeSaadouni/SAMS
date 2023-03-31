package com.soufianesaadouni.sams.data.repository

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.soufianesaadouni.sams.data.model.Student
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await

//TODO CRUD here
//TODO use lazy column to display data from firestore
class StudentRepository(private val db: FirebaseFirestore, private val auth: FirebaseAuth) {
    private val collectionPath = "Students"

    suspend fun fetch(): List<Student> {
        val teacherID = auth.currentUser?.uid ?:return emptyList()
        val querySnapshot = db
            .collection(collectionPath)
            .get()
            .await()
        return querySnapshot.toObjects(Student::class.java)

    }

    suspend fun add(student: Student) {
        val teacherID = auth.currentUser?.uid ?:return
        val st1 = HashMap<String, Any>()
        st1["id"] = student.id
        st1["name"] = student.fullName

        db.collection(collectionPath)
            .document("student1")
            .set(st1)
            .addOnSuccessListener {
                //  TODO display snack bar for success
            }
            .addOnFailureListener {
                //TODO snack bar of failure
            }.await()
    }

    suspend fun update(studentID:String,student: Student) {
        val st1 = HashMap<String, Any>()
        st1["id"] = student.id
        st1["name"] = student.fullName
        db.collection(collectionPath).document(studentID).update(st1).await()
    }

    suspend fun delete(studentID: String) {
        db.collection(collectionPath).document(studentID).delete().await()
    }
}
