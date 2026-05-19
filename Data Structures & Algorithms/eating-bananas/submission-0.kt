class Solution {
    fun minEatingSpeed(piles: IntArray, h: Int): Int {

        fun canEat(banana: Int): Boolean {

            var hour = 0

            for (pile in piles) {
                if (pile <= banana) {
                    hour += 1
                } else {
                    hour += (pile / banana)
                    if (pile % banana != 0) {
                        hour += 1
                    }
                }
            }

            return hour <= h

        }

        var right = 0
        for (pile in piles) {
            right = maxOf(right, pile)
        }
        var left = 1
        var min = Int.MAX_VALUE
        while (left <= right) {
            var mid = (left + right) / 2
            if (canEat(mid)) {
                min = minOf(min, mid)
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return min
    }
}
