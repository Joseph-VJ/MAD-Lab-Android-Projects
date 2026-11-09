package com.example.labapp

class TipCalculator {
    fun tip(bill: Double, percent: Int) = bill * percent / 10 // BUG: should be / 100
    fun total(bill: Double, percent: Int) = bill + tip(bill, percent)
}
