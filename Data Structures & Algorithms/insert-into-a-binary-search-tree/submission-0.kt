/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun insertIntoBST(root: TreeNode?, `val`: Int): TreeNode? {

        if (root == null) {
            return TreeNode(`val`)
        }

        if (root!!.`val` < `val`) {
            root?.right = insertIntoBST(root?.right, `val`)
        } else {
            root?.left = insertIntoBST(root?.left, `val`)
        }

        return root

    }
}
