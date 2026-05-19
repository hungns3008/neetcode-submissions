/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {

    fun findLeftMost(node: TreeNode?): TreeNode? {
        if (node?.left == null && node?.right == null) {
            return node
        }
        if (node?.left != null) {
            return findLeftMost(node?.left)
        }
        return node
    }

    fun deleteNode(root: TreeNode?, key: Int): TreeNode? {

        if (root == null) {
            return null
        }
        if (root!!.`val` < key) {
            root?.right = deleteNode(root?.right, key)
        } else if (root!!.`val` > key) {
            root?.left = deleteNode(root?.left, key)
        } else {
            if (root?.right == null) {
                return root?.left
            } else {
                var leftMost = findLeftMost(root?.right)
                root!!.`val` = leftMost!!.`val`
                root?.right = deleteNode(root?.right, leftMost!!.`val`)       
            }
        }

        return root

    }
}
