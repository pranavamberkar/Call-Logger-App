package com.example.callloggerapp.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.callloggerapp.models.Feedback

@Dao
interface FeedbackDao {
    @Insert
    suspend fun insertFeedback(feedback: Feedback)
    @Query("SELECT * FROM feedback_table ORDER BY time DESC")
    fun getAllFeedback(): List<Feedback>

}