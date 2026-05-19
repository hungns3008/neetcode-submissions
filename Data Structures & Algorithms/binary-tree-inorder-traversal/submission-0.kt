/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {

    fun inorderTraversal(root: TreeNode?): List<Int> {

        var output = mutableListOf<Int>()
        
        fun travel(node: TreeNode?) {
            if (node == null) {
                return
            }
            travel(node?.left)
            if (node != null) {
                output.add(node!!.`val`)
            }
            travel(node?.right)
        }

        travel(root)

        return output

    }
}
