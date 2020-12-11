package com.example.shopping.services

import com.example.shopping.model.Product
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.RequestBody
import java.util.concurrent.ConcurrentHashMap

@Component
class ProductServiceImpl: ProductService{
    companion object{
        val initialProducts: Array<Product> = arrayOf(
                Product(1, "Nike Air Force", "https://static.nike.com/a/images/c_limit,w_592,f_auto/t_product_v1/d32876be-ea06-46e3-b3cb-1c36e399e200/air-force-1-pixel-shoe-v5Q8c2.jpg", 129.99, "Sould Out"),
                Product(2, "Nike Force 1", "https://static.nike.com/a/images/c_limit,w_592,f_auto/t_product_v1/xj21lifym832hj2iqjen/force-1-younger-shoe-vXJB1w.jpg", 54.99, "Sould Out"),
                Product(3, "LA Clippers", "https://static.nike.com/a/images/c_limit,w_592,f_auto/t_product_v1/4bfcfefa-9949-4fe6-be4d-933d762492be/la-clippers-city-edition-nba-swingman-jersey-X65pq4.jpg", 99.99, "Nike NBA Swigman Jersey"),
                Product(4, "Pitstons Statement Edition 2020", "https://static.nike.com/a/images/c_limit,w_592,f_auto/t_product_v1/e3c68189-6549-4fa1-b7d3-bafdd943ee4d/pistons-statement-edition-2020-jordan-nba-swingman-shorts-XBTSps.jpg", 64.99, "Men's JORDAN NBA"),
                Product(5, "Nike Pro", "https://static.nike.com/a/images/c_limit,w_592,f_auto/t_product_v1/pltjbjd37aeampeswaqh/pro-adjustable-hat-71t09z.jpg", 19.99, "Hat"),
                Product(6, "Nike SB ZOOM Stefan Janoski", "https://static.nike.com/a/images/c_limit,w_592,f_auto/t_product_v1/bc35c26d-3b19-436e-b6b3-9c170755caf3/sb-zoom-stefan-janoski-fl-rm-skate-shoe-X5gzTV.jpg", 85.99, "Setfan janoski"),
                Product(7, "NIKE SB AeroBill", "https://static.nike.com/a/images/c_limit,w_592,f_auto/t_product_v1/yjzhehbqd04wnszuwt1d/sb-aerobill-pro-2-skate-hat-tT4x21.jpg", 29.99, "NIKE SB AEROBILL PRO 2.0"),

        )
    }

    var products: ConcurrentHashMap<Long, Product> =
            ConcurrentHashMap<Long, Product>(initialProducts.associateBy(Product::id))

    override fun getProduct(id:Long) = products[id]


    override fun getAll(nameFilter: String) =
            products.filter {
                it.value.name.contains(nameFilter, true)
            }.map (Map.Entry<Long, Product>::value ).toList()

    override fun createProduct(@RequestBody product: Product) {
        products[product.id] = product
    }

}