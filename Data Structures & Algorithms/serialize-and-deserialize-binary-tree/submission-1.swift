/**
 * Definition for a binary tree node.
 * class TreeNode {
 *     var val: Int
 *     var left: TreeNode?
 *     var right: TreeNode?
 *     init(_ val: Int) {
 *         self.val = val
 *         self.left = nil
 *         self.right = nil
 *     }
 * }
 */

class Codec {

    var current = ""
    
    func dfs(_ node: TreeNode?) {
        if node == nil {
            current += "N "
            return
        }
        current += "\(node!.val) "
        dfs(node?.left)
        dfs(node?.right)
    }

    // Encodes a tree to a single string.
    func serialize(_ root: TreeNode?) -> String {
        current = ""
        dfs(root)
        return current.trimmingCharacters(in: .whitespacesAndNewlines)
    }

    // Decodes your encoded data to tree.
    func deserialize(_ data: String) -> TreeNode? {

        var arr = data.split(separator: " ")

        if arr.count == 0 {
            return nil
        }

        var i = 0

        func buildNode() -> TreeNode? {
            if arr[i] == "N" {
                i += 1
                return nil
            }
            var node = TreeNode(Int(arr[i])!)
            i += 1
            node.left = buildNode()
            node.right = buildNode()

            return node
        }

        return buildNode()

    }
}
