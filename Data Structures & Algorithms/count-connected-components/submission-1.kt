class Solution {
    fun countComponents(n: Int, edges: Array<IntArray>): Int {
        var par = IntArray(n) { 0 }
        var rank = IntArray(n) { 0 }

        for (i in 0 until n) {
            par[i] = i
        }
        var output = n

        fun find(n: Int): Int {
            if (n != par[n]) {
                par[n] = find(par[n])
            }
            return par[n]
        }

        fun union(n1: Int, n2: Int): Boolean {
            val p1 = find(n1)
            val p2 = find(n2)
            if (p1 == p2) {
                return false
            }
            if (rank[p1] >= rank[p2]) {
                par[p2] = p1
                rank[p1] += 1
            } else {
                par[p1] = p2
                rank[p2] += 1
            }
            return true
        }

        for (edge in edges) {
            if (union(edge[0], edge[1])) {
                output -= 1
            }
        }

        return output
    }
}
