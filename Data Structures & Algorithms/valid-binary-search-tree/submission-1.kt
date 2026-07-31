/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {

    fun isValid(root: TreeNode?, leftMax: Int, rightMax: Int): Boolean {

        if (root == null) {
            return true
        }

        var isValid = false
        if (root!!.`val` > leftMax && root!!.`val` < rightMax) {
            isValid = true
        }

        var left = root?.left
        var right = root?.right

        if (left != null) {
            isValid = left!!.`val` < root!!.`val`
        }

        if (right != null && isValid) {
            isValid = right!!.`val` > root!!.`val`
        }

        return isValid && 
        isValid(root?.left, leftMax, root!!.`val`) && 
        isValid(root?.right, root!!.`val`, rightMax)

    }

    fun isValidBST(root: TreeNode?): Boolean {
        return isValid(root, Int.MIN_VALUE, Int.MAX_VALUE)
    }
}
