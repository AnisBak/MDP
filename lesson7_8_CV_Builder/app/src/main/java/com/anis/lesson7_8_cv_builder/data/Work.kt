package com.anis.lesson7_8_cv_builder.data

import java.io.Serializable

data class Work(
    val title: String,
    val position: String,
    val duration: String,
    val image: Int
) : Serializable