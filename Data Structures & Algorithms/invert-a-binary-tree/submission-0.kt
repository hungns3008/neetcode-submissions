/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun invertTree(root: TreeNode?): TreeNode? {

        if (root == null) {
            return null
        }
        var left = invertTree(root?.right)
        var right = invertTree(root?.left)

        root?.left = left
        root?.right = right

        return root

    }
}
