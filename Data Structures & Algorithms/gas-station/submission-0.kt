class Solution {
    fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {

        var cache = HashMap<IntArray, Boolean>()

        fun dfs(currentGas: Int, currentIndex: Int, endIndex: Int): Boolean {

            if (currentIndex == endIndex) {
                return true
            }

            if (cache[intArrayOf(currentGas, currentIndex, endIndex)] != null) {
                return cache[intArrayOf(currentGas, currentIndex, endIndex)]!!
            }

            var newEndIndex = if (endIndex == Int.MIN_VALUE) { currentIndex } else { endIndex }

            var tank = currentGas + gas[currentIndex]

            val nextIndex = (currentIndex + 1) % gas.count()
            if (cost[currentIndex] <= tank) {
                if (dfs(tank - cost[currentIndex], nextIndex, newEndIndex)) {
                    cache[intArrayOf(currentGas, currentIndex, endIndex)] = true
                    return true
                }
            }

            cache[intArrayOf(currentGas, currentIndex, endIndex)] = false

            return false

        }

        for (i in 0 until gas.count()) {
            if (dfs(0, i, Int.MIN_VALUE)) {
                return i
            }
        }

        return -1

    }
}