/*
Definition for a Node.
class Node {
    var val: Int
    var neighbors: [Node?]
    init(_ val: Int) {
        self.val = val
        self.neighbors = []
    }
}
*/

class Solution {

    var hash = [ObjectIdentifier: Node]() // old : new

    func cloneGraph(_ node: Node?) -> Node? {

        if node == nil {
            return nil
        }

        if hash[ObjectIdentifier(node!)] != nil {
            return hash[ObjectIdentifier(node!)]
        }

        var newNode = Node(node!.val)
        hash[ObjectIdentifier(node!)] = newNode

        for neighbor in node!.neighbors {
            newNode.neighbors.append(
                cloneGraph(neighbor)
            )
        }

        return newNode

    }
}
