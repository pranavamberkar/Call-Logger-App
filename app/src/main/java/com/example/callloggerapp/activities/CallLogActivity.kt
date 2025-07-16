package com.example.callloggerapp.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.callloggerapp.adapters.CallLogAdapter
import com.example.callloggerapp.data.AppDatabase
import com.example.callloggerapp.databinding.ActivityCallLogBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CallLogActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCallLogBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCallLogBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lifecycleScope.launch(Dispatchers.IO) {
            val feedbackList = AppDatabase.getDatabase(applicationContext)
                .feedbackDao().getAllFeedback()

            withContext(Dispatchers.Main) {
                binding.callLogRecyclerView.layoutManager = LinearLayoutManager(this@CallLogActivity)
                binding.callLogRecyclerView.adapter = CallLogAdapter(feedbackList)
            }
        }
    }
}
