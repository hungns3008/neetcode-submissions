/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun rightSideView(root: TreeNode?): List<Int> {
        var stack = LinkedList<TreeNode?>()
        stack.add(root)

        var output = mutableListOf<Int>()

        while (stack.count() > 0) {
            val size = stack.count()
            for (i in 0 ..< size) {
                stack.removeFirst()?.let { node ->
                    if (i == size - 1) {
                        output.add(node.`val`)
                    }
                    if (node.left != null) {
                        stack.add(node.left)
                    }
                    if (node.right != null) {
                        stack.add(node.right)
                    }
                }
            }
        }

        return output
    }
}
