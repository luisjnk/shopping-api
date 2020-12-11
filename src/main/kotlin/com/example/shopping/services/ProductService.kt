package com.example.shopping.services

import com.example.shopping.model.Product

interface ProductService {
    fun getProduct(id:Long): Product?

    fun getAll(nameFilter: String): List<Product>

    fun createProduct(product: Product)

}