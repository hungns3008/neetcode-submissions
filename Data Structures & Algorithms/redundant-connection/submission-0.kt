class Solution {

    fun findRedundantConnection(edges: Array<IntArray>): IntArray {
        var par = HashMap<Int, Int>()
        var rank = IntArray(edges.count() + 1) { 0 }

        for (i in 1 .. edges.count()) {
            par[i] = i
        }

        fun find(n: Int): Int {
            if (n != par[n]) {
                par[n] = find(par[n]!!)    
            }
            return par[n]!!
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

        for (edge in edges) {
            if (!union(edge[0], edge[1])) {
                return edge
            }
        }

        return intArrayOf()

    }
}
