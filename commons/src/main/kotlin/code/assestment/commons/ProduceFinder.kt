package code.assestment.commons

enum class ProduceFinder {
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