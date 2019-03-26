
val pentagonalList = mutableListOf<Int>()
val pentagonalSet = mutableSetOf<Int>()

fun pentagonal(n: Int): Int {
    return n * (3 * n - 1) / 2
}

fun isPentagonal(v: Int): Boolean {
    var max = if (pentagonalList.isEmpty()) 0 else pentagonalList.last()
    while (v > max) {
        max = pentagonal(pentagonalList.size + 1)
        pentagonalList.add(max)
        pentagonalSet.add(max)
    }
    return pentagonalSet.contains(v)
}

var i = 0
loop@ while (true) {
    while (i >= pentagonalList.size) {
        val p = pentagonal(pentagonalList.size + 1)
        pentagonalList.add(p)
        pentagonalSet.add(p)
    }
    for (j in 0..i) {
        val a = pentagonalList[i]
        val b = pentagonalList[j]
        if (isPentagonal(a + b) && isPentagonal(a - b)) {
            val d = Math.abs(a - b)
            println(d)
            break@loop
        }
    }
    i++
}

