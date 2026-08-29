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
    func goodNodes(_ root: TreeNode?) -> Int {

        func dfs(_ node: TreeNode?, _ maxValue: Int) -> Int {

            if node == nil {
                return 0
            }

            var left = dfs(node?.left, max(maxValue, node!.val))
            var right = dfs(node?.right, max(maxValue, node!.val))

            if node!.val >= maxValue {
                return 1 + left + right
            }
            return left + right

        }

        return dfs(root, Int.min)

    }
}
