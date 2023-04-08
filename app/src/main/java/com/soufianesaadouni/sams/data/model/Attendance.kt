package com.soufianesaadouni.sams.data.model

import com.google.type.DateTime

data class Attendance(val dateTime: DateTime, val location: String, val absentIDs: List<String>)
