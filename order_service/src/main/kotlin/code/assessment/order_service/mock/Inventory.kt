package code.assessment.order_service.mock

import code.assessment.order_service.utils.Product
import code.assestment.commons.ProduceIndex

class Inventory {
    companion object {
        private var oranges = 4
        private var apples = 5

        fun getInventoryForProduct(product: Product): Int {
            return when (product){
                Product.APPLE -> apples
                ProduceIndex.ORANGE -> oranges
            }
        }
    }
}