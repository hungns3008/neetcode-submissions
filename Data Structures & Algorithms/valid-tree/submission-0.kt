class Solution {
    fun validTree(n: Int, edges: Array<IntArray>): Boolean {

        var rank = IntArray(n) { 0 }
        var par = IntArray(n) { 0 }
        for (i in 0 until n) {
            par[i] = i
        }

        fun find(n: Int): Int {
            if (n != par[n]) {
                par[n] = find(par[n])
            }
            return par[n]
        }

        fun union(n1: Int, n2: Int): Boolean {
            var p1 = find(n1)
            var p2 = find(n2)
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

        if (edges.size != n - 1) return false

        for (edge in edges) {
            if (!union(edge[0], edge[1])) {
                return false
            }
        }
        return true

    }
}