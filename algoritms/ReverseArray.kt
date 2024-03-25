fun reverseArray(arr: IntArray) {
    var left = 0
    var right = arr.size - 1

    while (left < right) {
        val temp = arr[left]
        arr[left] = arr[right]
        arr[right] = temp
        left++
        right--
    }
}
