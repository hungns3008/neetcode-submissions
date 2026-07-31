/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {

    fun isSame(p: TreeNode?, q: TreeNode?): Boolean {
        if (p == null && q == null) {
            return true
        }
        if (p == null || q == null) {
            return false
        }
        return p.`val` == q.`val` && isSame(p.left, q.left) && isSame(p.right, q.right)
    }

    fun isSubtree(root: TreeNode?, subRoot: TreeNode?): Boolean {
        if (root == null) return false
        return isSame(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot)
    }
}