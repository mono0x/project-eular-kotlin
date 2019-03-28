val numOfFactors = 4

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

fun isNFactor(n: Long): Boolean {
    var t = n
    var count = 0
    for (i in primes) {
        if (t < i) {
            return false
        }
        if (t % i == 0L) {
            count++
            while (t % i == 0L) {
                t /= i
            }
        }
        if (count == numOfFactors) {
            return t == 1L
        }
    }
    return false
}

val result = mutableListOf<Long>()

for (i in 1..Long.MAX_VALUE) {
    if (isPrime(i)) {
        result.clear()
        continue
    }

    if (!isNFactor(i)) {
        result.clear()
        continue
    }
    result.add(i)
    if (result.size == numOfFactors) {
        println(result[0])
        break
    }
}
