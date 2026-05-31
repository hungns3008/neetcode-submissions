class Solution {
    fun accountsMerge(accounts: List<List<String>>): List<List<String>> {
        var emailToName = HashMap<String, String>()
        var adjList = HashMap<String, MutableList<String>>()

        for (account in accounts) {
            val name = account[0]
            for (i in 1 until account.count()) {
                emailToName[account[i]] = name
            }
        }
        for (account in accounts) {
            if (adjList[account[1]] == null) {
                adjList[account[1]] = mutableListOf()
            } 
            for (i in 2 until account.count()) {
                adjList[account[1]]!!.add(account[i])
                if (adjList[account[i]] == null) {
                    adjList[account[i]] = mutableListOf()
                }
                adjList[account[i]]!!.add(account[1])
            }
        }
        
        var result = mutableListOf<List<String>>()
        var visited = mutableSetOf<String>()
        fun dfs(account: String, currentList: MutableList<String>) {
            if (visited.contains(account)) {
                return
            }
            visited.add(account)
            currentList.add(account)
            var neighbors = adjList[account] ?: listOf()
            for (neighbor in neighbors) {
                dfs(neighbor, currentList)
            }
        }

        for ((account, _) in adjList) {
            val name = emailToName[account]!!
            val currentList = mutableListOf<String>()
            dfs(account, currentList)
            if (currentList.count() > 0) {
                currentList.sort()
                currentList.add(0, name)
                result.add(currentList.toList())
            }
        }

        return result
    }
}
