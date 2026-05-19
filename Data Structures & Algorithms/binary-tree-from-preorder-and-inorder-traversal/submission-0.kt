/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        // rLR
        // LrR

        var map = HashMap<Int, Int>()
        for (i in 0 ..< inorder.count()) {
            map[inorder[i]] = i
        }

        var currentIndex = 0

        fun buildNode(left: Int, right: Int): TreeNode? {
            if (left > right) {
                return null
            }
            val rootValue = preorder[currentIndex]!!
            val rootIndex = map[rootValue]!!
            var root = TreeNode(rootValue)

            currentIndex += 1
            root.left = buildNode(left, rootIndex - 1)
            root.right = buildNode(rootIndex + 1, right)
            
            return root
        }

        return buildNode(0, preorder.lastIndex)
    }
}
