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

    func depth(_ node: TreeNode?) -> Int {
        if node == nil {
            return 0
        }
        return 1 + max(depth(node?.left), depth(node?.right))
    }

    func isBalanced(_ root: TreeNode?) -> Bool {
        if root == nil {
            return true
        }
        var leftHeight = depth(root?.left)
        var rightHeight = depth(root?.right)
        return abs(leftHeight - rightHeight) <= 1 && isBalanced(root?.left) && isBalanced(root?.right)

    }
}
