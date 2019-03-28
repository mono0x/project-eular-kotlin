val primes = linkedSetOf<Long>()
var current = 1L

fun isPrime(n: Long): Boolean {
    while (current < n) {
        current++
        if (primes.all { current % it != 0L }) {
            primes.add(current)
        }
    }
    return primes.contains(n)
}

fun isSquared(n: Long): Boolean {
    for (i in 1..n) {
        if (i * i == n) {
            return true
        }
        if (i * i > n) {
            return false
        }
    }
    return false
}

fun match(n: Long): Boolean {
    for (i in primes) {
        if (n == i) {
            continue
        }
        if ((n - i) % 2 != 0L) {
            continue
        }
        val squared = (n - i) / 2
        if (isSquared(squared)) {
            return true
        }
    }
    return false
}

for (i in 3L..Long.MAX_VALUE step 2) {
    if (isPrime(i)) {
        continue
    }

    if (!match(i)) {
        println(i)
        break
    }
}

