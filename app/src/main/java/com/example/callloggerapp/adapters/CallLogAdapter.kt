package com.example.callloggerapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.callloggerapp.databinding.CallLogItemBinding
import com.example.callloggerapp.models.Feedback
import java.text.SimpleDateFormat
import java.util.*

class CallLogAdapter(private val feedbackList: List<Feedback>) :
    RecyclerView.Adapter<CallLogAdapter.LogViewHolder>() {

    inner class LogViewHolder(val binding: CallLogItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LogViewHolder {
        val binding = CallLogItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LogViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LogViewHolder, position: Int) {
        val feedback = feedbackList[position]

        holder.binding.statusText.text = "Status: ${feedback.rating}"
        holder.binding.commentText.text = feedback.comment

        val dateFormat = SimpleDateFormat("dd MMM yyyy, hh:mm a", Locale.getDefault())
        val dateString = dateFormat.format(Date(feedback.time))
        holder.binding.timeText.text = "Time: $dateString"
    }

    override fun getItemCount(): Int = feedbackList.size
}
