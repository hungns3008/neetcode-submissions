/**
 * Definition for a binary tree node.
 * class TreeNode {
 *     var val: Int
 *     var left: TreeNode?
 *     var right: TreeNode?
 *     init(_ val: Int) {
 *         self.val = val
 *         self.left = nil
 *         self.right = nil
 *     }
 * }
 */

class Solution {
    func maxPathSum(_ root: TreeNode?) -> Int {

        var output = Int.min

        func dfs(_ node: TreeNode?) -> Int {
            if node == nil {
                return 0
            }
            var currentValue = node!.val
            var maxLeft = dfs(node?.left)
            var maxRight = dfs(node?.right)

            output = max(output, maxLeft + maxRight + currentValue)

            return max(0, currentValue + max(maxLeft, maxRight))
        }

        dfs(root)

        return output

    }
}
