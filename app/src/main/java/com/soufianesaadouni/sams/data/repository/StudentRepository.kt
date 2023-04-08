package com.soufianesaadouni.sams.data.repository

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.soufianesaadouni.sams.data.model.Student
import kotlinx.coroutines.tasks.await

//TODO CRUD here
//TODO use lazy column to display data from firestore
class StudentRepository(
    private val db: FirebaseFirestore,
    auth: FirebaseAuth,
    private val classeID: String
) {
    private val teacherID = auth.currentUser?.uid ?: "Empty!"

    suspend fun fetch(): List<Student> {
        val querySnapshot = db
            .collection("Teachers")
            .document(teacherID)
            .collection("Classes")
            .document(classeID)
            .collection("Students")
            .get()
            .await()
        return querySnapshot.toObjects(Student::class.java)
    }

    suspend fun add(student: Student) {
        val st1 = HashMap<String, Any>()
        st1["name"] = student.fullName
        st1["email"] = student.email

        db
            .collection("Teachers")
            .document(teacherID)
            .collection("Classes")
            .document(classeID)
            .collection("Students")
            .document()
            .set(st1)
            .addOnSuccessListener {
                //  TODO display snack bar for success
            }
            .addOnFailureListener {
                //TODO snack bar of failure
            }.await()
    }

    suspend fun update(studentID: String, student: Student) {
        val st1 = HashMap<String, Any>()
        st1["name"] = student.fullName
        st1["email"] = student.email

        db
            .collection("Teachers")
            .document(teacherID)
            .collection("Classes")
            .document(classeID)
            .collection("Students")
            .document(studentID)
            .update(st1)
            .await()
    }

    suspend fun delete(studentID: String) {
        db
            .collection("Teachers")
            .document(teacherID)
            .collection("Classes")
            .document(classeID)
            .collection("Students")
            .document(studentID)
            .delete()
            .await()
    }

    suspend fun getById(studentID: String): Student? {
        val documentReference = db
            .collection("Teachers")
            .document(teacherID)
            .collection("Classes")
            .document(classeID)
            .collection("Students")
            .document(studentID)
            .get()
            .await()
        return documentReference.toObject(Student::class.java)
    }
}
