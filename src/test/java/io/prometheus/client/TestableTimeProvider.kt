package io.prometheus.client

internal class TestableTimeProvider : SimpleTimer.TimeProvider() {
    private var baseTime = System.currentTimeMillis()

    public override fun nanoTime(): Long {
        val curr = baseTime
        baseTime += 1979L
        return curr
    }

    companion object {
        fun install() {
            SimpleTimer.defaultTimeProvider = TestableTimeProvider()
        }
    }
}