package code.assestment.commons

enum class ProduceIndex {
    APPLE {
        override val pick: Produce
            get() = Apple()
    },
    ORANGE {
        override val pick: Produce
            get() = Orange()
    };

    abstract val pick: Produce
}