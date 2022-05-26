package com.example.secondhand.dto

data class UpdateUserRequest (val id: Long,
                              val firstName: String,
                              val middleName: String,
                              val lastName: String){
}