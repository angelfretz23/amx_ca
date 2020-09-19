package code.assestment.commons

enum class ProduceFinder {
    APPLE {
        override val produce: Produce
            get() = Apple()
    },
    ORANGE {
        override val produce: Produce
            get() = Orange()
    };

    abstract val produce: Produce
}