package com.anis.lesson7_8_cv_builder.data

import java.io.Serializable

data class User(
    val firstname: String,
    val lastname: String,
    val username: String,
    val password: String
) : Serializable