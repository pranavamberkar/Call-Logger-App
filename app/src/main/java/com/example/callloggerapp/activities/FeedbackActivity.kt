package com.example.callloggerapp.activities

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.callloggerapp.R
import com.example.callloggerapp.data.AppDatabase
import com.example.callloggerapp.databinding.ActivityFeedbackBinding
import com.example.callloggerapp.models.Feedback
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FeedbackActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFeedbackBinding
    private var contactName: String = "Unknown Contact"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFeedbackBinding.inflate(layoutInflater)
        setContentView(binding.root)

        contactName = intent.getStringExtra("calledPerson") ?: "Unknown Contact"
        binding.contactName.text = "Feedback for: $contactName"

        val statuses = listOf("Connected", "Busy", "Not Answered")
        val adapter = ArrayAdapter(this, R.layout.spinner_item, statuses)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.ratingSpinner.adapter = adapter
        binding.ratingSpinner.setSelection(0)

        binding.submitButton.setOnClickListener {
            val selectedStatus = binding.ratingSpinner.selectedItem.toString()
            val comments = binding.commentEditText.text.toString().trim()

            if (comments.isEmpty()) {
                Toast.makeText(this, "Please enter a comment.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val feedback = Feedback(
                rating = selectedStatus,
                comment = "[$contactName] $comments",
                time = System.currentTimeMillis()
            )

            lifecycleScope.launch(Dispatchers.IO) {
                AppDatabase.getDatabase(applicationContext).feedbackDao().insertFeedback(feedback)

                launch(Dispatchers.Main) {
                    Toast.makeText(this@FeedbackActivity, "Feedback saved!", Toast.LENGTH_SHORT).show()
                    finish()
                }
            }
        }
    }
}
