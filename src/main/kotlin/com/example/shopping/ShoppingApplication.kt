package com.example.shopping

import com.example.shopping.model.Product
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.reactive.CorsWebFilter
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource
import java.util.concurrent.ConcurrentHashMap

@SpringBootApplication
class ShoppingApplication{
}

@Bean
fun corsFilter(): CorsWebFilter = CorsWebFilter(
		UrlBasedCorsConfigurationSource().apply {
			registerCorsConfiguration(
					"/**",
					CorsConfiguration().apply {
						allowCredentials = true
						allowedOrigins = listOf("*")
						allowedHeaders = listOf("*")
						allowedMethods = listOf("*")
					}
			)
		}
)

fun main(args: Array<String>) {
	runApplication<ShoppingApplication>(*args)
	corsFilter()
}
