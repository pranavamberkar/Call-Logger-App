package com.example.callloggerapp.utils

import com.example.callloggerapp.models.Contact

object DummyContactProvider {
    fun getContacts(): List<Contact> {
        return listOf(
            Contact("Rahul Sharma", "9876543210"),
            Contact("Priya Mehta", "9123456780"),
            Contact("Anjali Singh", "9988776655"),
            Contact("Vivek Singh", "9893983956")
        )
    }
}
