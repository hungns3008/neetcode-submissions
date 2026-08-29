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

class Solution {
    func rightSideView(_ root: TreeNode?) -> [Int] {

        if root == nil {
            return []
        }

        var queue = [TreeNode]()
        queue.append(root!)

        var output = [Int]()

        while queue.count > 0 {
            var size = queue.count
            for i in 0 ..< size {
                var node = queue.removeFirst()
                if node.left != nil {
                    queue.append(node.left!)
                }
                if node.right != nil {
                    queue.append(node.right!)
                }
                if i == size - 1 {
                    output.append(node.val)
                }
            }
        }

        return output

    }
}
