/*
// Definition for a Node.
class Node {
    var val: Int
    var next: Node?
    var random: Node?
    init(_ val: Int) {
        self.val = val
        self.next = nil
        self.random = nil
    }
}
*/

class Solution {
    func copyRandomList(_ head: Node?) -> Node? {

        var hash = [Node: Node]() // old: new

        func getNode(_ node: Node?) -> Node? {
            if node == nil {
                return nil
            }
            if hash[node!] != nil {
                return hash[node!]!
            }
            var newNode = Node(node!.val)
            hash[node!] = newNode
            newNode.next = getNode(node?.next)
            newNode.random = getNode(node?.random)
            return newNode
        }

        return getNode(head)

    }
}
