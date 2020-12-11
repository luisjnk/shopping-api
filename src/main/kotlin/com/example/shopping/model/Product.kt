package com.example.shopping.model

data class Product (
        val id: Long,
        val name: String,
        val imageUrl: String,
        val price: Double,
        val description: String
)