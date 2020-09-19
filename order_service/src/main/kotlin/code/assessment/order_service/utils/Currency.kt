package code.assessment.order_service.utils

import java.text.NumberFormat
import java.util.*
import java.util.Currency

class Currency {
    companion object {
        fun <T: Number> format(num: T): String {
            val formatter = NumberFormat.getCurrencyInstance()
            formatter.maximumFractionDigits = 2
            formatter.currency = Currency.getInstance(Locale.US)
            return formatter.format(num) ?: "$0.00"
        }
    }
}