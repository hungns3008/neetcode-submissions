class Solution {
    fun findItinerary(tickets: List<List<String>>): List<String> {
        val adj = HashMap<String, MutableList<String>>()
        val sorted = tickets.sortedWith(Comparator<List<String>>() { c1, c2 -> 
            c1[1].compareTo(c2[1])
        })
        for (ticket in sorted) {
            if (adj[ticket[0]] == null) {
                adj[ticket[0]] = mutableListOf()
            }
            adj[ticket[0]]!!.add(ticket[1])
        }
        val res = mutableListOf("JFK")

        fun dfs(src: String): Boolean {
            if (res.size == sorted.size + 1) {
                return true
            }

            val destinations = adj[src] ?: return false
            for (i in 0 until destinations.count()) {
                val v = destinations.removeAt(i)
                res.add(v)

                if (dfs(v)) {
                    return true
                }

                destinations.add(i, v)
                res.removeLast()
            }
            return false
        }

        dfs("JFK")
        return res
    }
}
