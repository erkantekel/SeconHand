package com.example.secondhand.dto

class CreateUserRequest(val id: Long,
                        val mail: String,
                        val firstName: String,
                        val middleName: String,
                        val lastName: String) {
}