package code.assestment.commons

class Orange(override val id: String = "ORANGE"): Produce(id) {
    override val price: Float
        get() = 0.25F
}