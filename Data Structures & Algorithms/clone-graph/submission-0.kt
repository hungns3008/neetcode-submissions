/*
Definition for a Node.
class Node(var `val`: Int) {
    var neighbors: ArrayList<Node?> = ArrayList()
}
*/

class Solution {
    fun cloneGraph(node: Node?): Node? {

        // old : new
        var hashNode = HashMap<Node, Node>()

        fun dfs(root: Node?): Node? {
            if (root == null) {
                return null
            }
            if (hashNode[root!!] != null) {
                return hashNode[root!!]
            }
            val newNode = Node(root!!.`val`)
            hashNode[root] = newNode
            for (neighbor in root!!.neighbors) {
                newNode.neighbors.add(dfs(neighbor))
            }
            return newNode
        }

        return dfs(node)

    }
}
