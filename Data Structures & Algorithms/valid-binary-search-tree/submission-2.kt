/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {

    fun isValid(root: TreeNode?, leftMax: Long, rightMax: Long): Boolean {

        if (root == null) {
            return true
        }

        if (root.`val`.toLong() <= leftMax || root.`val`.toLong() >= rightMax) {
            return false
        }

        return isValid(root.left, leftMax, root.`val`.toLong()) && 
        isValid(root.right, root.`val`.toLong(), rightMax)

    }

    fun isValidBST(root: TreeNode?): Boolean {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE)
    }
}