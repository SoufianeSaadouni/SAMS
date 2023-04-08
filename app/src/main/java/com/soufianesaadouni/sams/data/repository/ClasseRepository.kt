package com.soufianesaadouni.sams.data.repository

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.soufianesaadouni.sams.data.model.Classe
import kotlinx.coroutines.tasks.await

// Teachers(collection) -> Classes(collection) -> Students(collection)
//https://i.stack.imgur.com/9EabI.png
class ClasseRepository(private val db: FirebaseFirestore, auth: FirebaseAuth) {
    private val teacherID = auth.currentUser!!.uid

    suspend fun fetch(): List<Classe> {
        val querySnapshot = db
            .collection("Teachers")
            .document(teacherID)
            .collection("Classes")
            .get()
            .await()

        return querySnapshot.map {
            Classe(id = it.id, name = it.data["name"].toString())
        }

        //return querySnapshot.toObjects(Classe::class.java)
    }

    suspend fun add(classe: Classe) {
        val classeData = hashMapOf(
            "name" to classe.name,
        )

        db
            .collection("Teachers")
            .document(teacherID)
            .collection("Classes")
            .document()
            .set(classeData)
            .addOnSuccessListener {
                //  TODO display snack bar for success
            }
            .addOnFailureListener {
                //TODO snack bar of failure
            }.await()
    }

    suspend fun update(classeID: String, classe: Classe) {
        db
            .collection("Teachers")
            .document(teacherID)
            .collection("Classes")
            .document(classeID)
            .update("name", classe.name)
            .addOnSuccessListener {
                //  TODO display snack bar for success
            }
            .addOnFailureListener {
                //TODO snack bar of failure
            }
            .await()
    }

    suspend fun delete(classeID: String) {
        db
            .collection("Teachers")
            .document(teacherID)
            .collection("Classes")
            .document(classeID)
            .delete()
            .await()
    }

    suspend fun getByID(classeID: String): Classe? {
        val documentSnapshot = db
            .collection("Teachers")
            .document(teacherID)
            .collection("Classes")
            .document(classeID)
            .get()
            .await()
        return documentSnapshot.toObject(Classe::class.java)
    }
}
