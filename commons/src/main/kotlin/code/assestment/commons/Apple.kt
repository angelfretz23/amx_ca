package code.assestment.commons

class Apple(override val id: String = "APPLE"): Produce(id) {
    override val price: Float
        get() = 0.60F
}