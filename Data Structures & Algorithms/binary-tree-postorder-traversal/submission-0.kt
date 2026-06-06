/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun postorderTraversal(root: TreeNode?): List<Int> {

        var output = mutableListOf<Int>()

        fun postorder(node: TreeNode?) {
            if (node == null) {
                return
            }
            postorder(node?.left)
            postorder(node?.right)
            output.add(node!!.`val`)
        }

        postorder(root)

        return output

    }
}
