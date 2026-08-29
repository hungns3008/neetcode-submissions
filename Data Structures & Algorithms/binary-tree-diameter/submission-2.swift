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
    func diameterOfBinaryTree(_ root: TreeNode?) -> Int {

        var output = 0

        func maxDepth(_ node: TreeNode?) -> Int {
            if node == nil {
                return 0
            }
            var left = maxDepth(node?.left)
            var right = maxDepth(node?.right)

            output = max(output, left + right)

            return 1 + max(left, right)
        }

        maxDepth(root)

        return output

    }
}
