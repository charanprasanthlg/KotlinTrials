package com.example.kotlintrials.model

import com.google.gson.annotations.SerializedName

data class DataModelItem(
    @SerializedName("completed")
    val completed: Boolean,
    val id: Int,
    val title: String,
    val userId: Int
)