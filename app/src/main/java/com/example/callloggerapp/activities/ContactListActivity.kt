package com.example.callloggerapp.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.callloggerapp.adapters.ContactAdapter
import com.example.callloggerapp.databinding.ActivityContactListBinding
import com.example.callloggerapp.utils.DummyContactProvider

class ContactListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityContactListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val contactList = DummyContactProvider.getContacts()
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = ContactAdapter(contactList)
    }
}
