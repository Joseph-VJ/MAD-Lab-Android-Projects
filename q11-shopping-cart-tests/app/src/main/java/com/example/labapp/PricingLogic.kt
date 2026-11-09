package com.example.labapp

class PricingLogic {
    fun subtotal(prices: List<Int>, qty: List<Int>) = prices.zip(qty) { p, q -> p * q }.sum()
    fun decrement(q: Int) = if (q > 0) q - 1 else 0
    fun isValid(code: String) = code == "SAVE10"
    fun total(sub: Int, code: String) = if (isValid(code)) sub * 90 / 100 else sub
}
