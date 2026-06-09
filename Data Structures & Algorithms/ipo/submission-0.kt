class Solution {
    fun findMaximizedCapital(k: Int, w: Int, profits: IntArray, capital: IntArray): Int {

        var validProfit = PriorityQueue<Int>(Comparator<Int>() { c1, c2 -> 
            c2 - c1
        })

        var currentCap = w
        var currentProject = 0

        var visited = mutableSetOf<Int>()

        fun checkValidProjects() {
            for (i in 0 until profits.count()) {
                if (capital[i] <= currentCap && !visited.contains(i)) {
                    visited.add(i)
                    validProfit.add(profits[i])
                }
            }
        }

        checkValidProjects()

        while (currentProject < k && validProfit.count() > 0) {
            currentProject += 1
            currentCap +=  validProfit.poll()!!
            checkValidProjects()
        }

        return currentCap

    }
}
