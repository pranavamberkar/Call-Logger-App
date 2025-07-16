package com.example.callloggerapp.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "feedback_table")
data class Feedback(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val rating: String,
    val comment: String,
    val time: Long
)
