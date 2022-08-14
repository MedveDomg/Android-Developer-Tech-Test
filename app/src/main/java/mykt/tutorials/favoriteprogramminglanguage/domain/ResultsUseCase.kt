package mykt.tutorials.favoriteprogramminglanguage.domain

class ResultsUseCase() {

    private val results = mutableListOf<Int>()

    fun addResult(id: Int) {
        results.add(id)
    }

    fun getResults(): String {
        if (results.isEmpty()) return "There aren't any results"
        val size = results.size.toDouble()
        val swiftCount = results.count { it == SWIFT_ID }
        val swiftPercentage =
            if (swiftCount == 0) 0.0 else (swiftCount / size) * 100
        val javaCount = results.count { it == JAVA_ID }
        val javaPercentage = if (javaCount == 0) 0.0 else (javaCount / size) * 100
        val kotlinCount = results.count { it == KOTLIN_ID }
        val kotlinPercentage = if (kotlinCount == 0) 0.0 else (kotlinCount / size) * 100
        return "Swift: $swiftPercentage%" +
                "\n" +
                "Java: $javaPercentage%" +
                "\n" +
                "Kotlin: $kotlinPercentage%"
    }

    companion object {
        const val SWIFT_ID = 1
        const val JAVA_ID = 2
        const val KOTLIN_ID = 3
    }
}