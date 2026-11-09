package com.example.labapp

import org.junit.Assert.*
import org.junit.Test

class PricingLogicTest {
    private val l = PricingLogic()
    @Test fun subtotalAddsUp() = assertEquals(350, l.subtotal(listOf(100, 50), listOf(2, 3)))
    @Test fun quantityNeverBelowZero() = assertEquals(0, l.decrement(0))
    @Test fun saveCodeGivesTenPercent() = assertEquals(180, l.total(200, "SAVE10"))
    @Test fun otherCodeIsInvalid() = assertFalse(l.isValid("ABC"))
}
