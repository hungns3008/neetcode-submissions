class Solution {
    fun replaceElements(arr: IntArray): IntArray {

        var newArr = arr

        var maxSoFar = newArr[newArr.lastIndex]
        newArr[arr.lastIndex] = -1
        var i = newArr.lastIndex - 1

        while (i >= 0) {
            val currentValue = newArr[i]
            newArr[i] = maxSoFar
            maxSoFar = maxOf(currentValue, maxSoFar)
            i -= 1
        }

        return newArr

    }
}
