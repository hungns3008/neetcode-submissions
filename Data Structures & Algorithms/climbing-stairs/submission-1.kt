class Solution {
    fun climbStairs(n: Int): Int {
        if (n == 0) {
            return 0
        }
        if (n == 1) {
            return 1
        }
        if (n == 2) {
            return 2
        }
        var p1 = 1
        var p2 = 2
        for (i in 3 .. n) {
            var temp = p2
            p2 += p1
            p1 = temp 
        }
        return p2
    }
}
