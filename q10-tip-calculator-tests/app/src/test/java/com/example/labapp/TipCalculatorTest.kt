package com.example.labapp

import org.junit.Assert.assertEquals
import org.junit.Test

class TipCalculatorTest {
    private val c = TipCalculator()
    @Test fun tipIs10Percent() = assertEquals(20.0, c.tip(200.0, 10), 0.01)
    @Test fun tipIs20Percent() = assertEquals(40.0, c.tip(200.0, 20), 0.01)
    @Test fun totalIncludesTip() = assertEquals(230.0, c.total(200.0, 15), 0.01)
}
