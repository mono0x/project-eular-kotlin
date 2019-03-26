abstract class Matcher {
    private var index = 1L
    var current = calculate(index)

    fun next(n: Long): Boolean {
        while (n > current) {
            current = calculate(++index)
        }
        return n == current
    }

    protected abstract fun calculate(n: Long): Long
}

class TriangleMatcher : Matcher() {
    override fun calculate(n: Long): Long {
        return n * (n + 1) / 2
    }
}


class PentagonalMatcher : Matcher() {
    override fun calculate(n: Long): Long {
        return n * (3 * n - 1) / 2
    }
}

class HexagonalMatcher : Matcher() {
    override fun calculate(n: Long): Long {
        return n * (2 * n - 1)
    }
}

val matchers = listOf(TriangleMatcher(), PentagonalMatcher(), HexagonalMatcher())

var i = 40756L
while (i < Long.MAX_VALUE) {
    if (matchers.map { it.next(i) }.all { it }) {
        println(i)
        break
    }
    i = matchers.map { it.current }.max()!!
}
