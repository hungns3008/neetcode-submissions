/*
// Definition for a Node.
class Node(var `val`: Int) {
    var next: Node? = null
    var random: Node? = null
}
*/

class Solution {
    fun copyRandomList(head: Node?): Node? {

        var hash = HashMap<Node?, Node?>() // old: new

        fun clone(node: Node?): Node? {
            if (node == null) {
                return null
            }
            if (hash[node] != null) {
                return hash[node]!!
            }
            val newNode = Node(node!!.`val`)
            hash[node] = newNode
            newNode.next = clone(node?.next)
            newNode.random = clone(node?.random)
            return newNode
        }

        return clone(head)

    }
}
