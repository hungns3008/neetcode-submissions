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
    func invertTree(_ root: TreeNode?) -> TreeNode? {

        if root == nil {
            return root
        }

        var left = invertTree(root?.left)
        var right = invertTree(root?.right)

        root?.left = right
        root?.right = left

        return root

    }
}
