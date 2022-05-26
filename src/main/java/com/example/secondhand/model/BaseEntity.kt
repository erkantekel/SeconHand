package com.example.secondhand.model

import java.time.LocalDate

data class BaseEntity (val createdDate: LocalDate? = null,
                       val updatedDate: LocalDate? = null){

}