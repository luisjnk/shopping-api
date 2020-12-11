package com.example.shopping.controllers

import com.example.shopping.model.Product
import com.example.shopping.services.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.concurrent.ConcurrentHashMap

@CrossOrigin(origins = arrayOf("*"), maxAge = 3600)
@RestController
@RequestMapping(value = ["products"])
class ProductController {

    @Autowired
    lateinit var productService: ProductService

    @GetMapping()
    fun getAll(@RequestParam(required = false, defaultValue = "") nameFilter: String): ResponseEntity<List<Product>> {
        var product = productService.getAll(nameFilter)
        var status = if (product == null) HttpStatus.NOT_FOUND else HttpStatus.OK
        return ResponseEntity(product, status)
    }

    @GetMapping("/{id}")
    fun getProduct(@PathVariable id:Long): ResponseEntity<Product> {
        var product = productService.getProduct(id)
        var status = if (product == null) HttpStatus.NOT_FOUND else HttpStatus.OK
        return ResponseEntity(product, status)
    }

    @PostMapping("")
    fun createProduct(@RequestBody product: Product): ResponseEntity<Unit> {
        productService.createProduct(product)
        return ResponseEntity(HttpStatus.CREATED)
    }
}