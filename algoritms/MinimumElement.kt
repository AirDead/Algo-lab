fun findMinimum(arr: IntArray): Int {
    var min = arr[0]
    for (i in 1 until arr.size) {
        if (arr[i] < min) {
            min = arr[i]
        }
    }
    return min
}
