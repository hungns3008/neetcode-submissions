/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {

    fun inorderTraversal(root: TreeNode?): List<Int> {

        var stack = LinkedList<TreeNode>()
        var current = root
        var output = mutableListOf<Int>()

        while (stack.count() > 0 || current != null) {
            while (current != null) {
                stack.add(current)
                current = current?.left
            }            
            current = stack.removeLast()
            output.add(current!!.`val`)
            current = current?.right
        }

        return output

    }
}
