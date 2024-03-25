fun findMaximum(arr: IntArray): Int {
    var max = arr[0]
    for (i in 1 until arr.size) {
        if (arr[i] > max) {
            max = arr[i]
        }
    }
    return max
}
