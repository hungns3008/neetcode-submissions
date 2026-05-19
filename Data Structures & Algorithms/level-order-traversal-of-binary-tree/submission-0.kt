/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        var stack = LinkedList<TreeNode?>()
        stack.add(root)
        var output = mutableListOf<List<Int>>()
        
        while (stack.count() > 0) {
            var temp = mutableListOf<Int>()
            val size = stack.count()
            for (i in 0 ..< size) {
                stack.removeFirst()?.let { node ->
                    temp.add(node.`val`)
                    if (node.left != null) {
                        stack.add(node.left)
                    }
                    if (node.right != null) {
                        stack.add(node.right)
                    }
                }
                
            }
            if (temp.count() != 0) {
                output.add(temp.toList())
            }
        }

        return output
    }
}
