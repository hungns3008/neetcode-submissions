/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun preorderTraversal(root: TreeNode?): List<Int> {

        var output = mutableListOf<Int>()

        fun preorder(node: TreeNode?) {
            if (node == null) {
                return
            }
            output.add(node!!.`val`)
            preorder(node?.left)
            preorder(node?.right)
        }

        preorder(root)

        return output

    }
}
