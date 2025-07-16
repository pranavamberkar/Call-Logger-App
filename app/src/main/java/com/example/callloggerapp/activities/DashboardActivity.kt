package com.example.callloggerapp.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.callloggerapp.data.AppDatabase
import com.example.callloggerapp.databinding.ActivityDashboardBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DashboardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lifecycleScope.launch(Dispatchers.IO) {
            val feedbackList = AppDatabase.getDatabase(applicationContext)
                .feedbackDao().getAllFeedback()

            val total = feedbackList.size
            val connected = feedbackList.count { it.rating == "Connected" }
            val busy = feedbackList.count { it.rating == "Busy" }
            val notAnswered = feedbackList.count { it.rating == "Not Answered" }

            withContext(Dispatchers.Main) {
                binding.totalCalls.text = "Total Calls: $total"
                binding.connectedCount.text = "Connected: $connected"
                binding.busyCount.text = "Busy: $busy"
                binding.notAnsweredCount.text = "Not Answered: $notAnswered"
            }
        }
    }
}
