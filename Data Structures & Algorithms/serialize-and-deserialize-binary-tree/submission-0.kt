/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Codec {
    // Encodes a tree to a single string.
    var res = mutableListOf<String>()

    fun preorder(root: TreeNode?) {
        if (root == null) {
            res.add("N")
            return
        }
        res.add("${root!!.`val`.toString()}")
        preorder(root?.left)
        preorder(root?.right)
    }

    fun serialize(root: TreeNode?): String {
        res.clear()
        preorder(root)
        return res.joinToString(",")
    }

    // Decodes your encoded data to tree.
    fun deserialize(data: String): TreeNode? {
        var res = data.split(",")
        var i = 0
        fun dfs(): TreeNode? {
            if (res[i] == "N") {
                i += 1
                return null
            }
            val node = TreeNode(res[i].toInt())
            i += 1
            node.left = dfs()
            node.right = dfs()
            return node
        }

        return dfs()
    }
}
