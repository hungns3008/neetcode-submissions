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
    func isValidBST(_ root: TreeNode?) -> Bool {

        func isValid(_ node: TreeNode?, _ leftMax: Int, _ rightMax: Int) -> Bool {

            if node == nil {
                return true
            }

            if node!.val <= leftMax || node!.val >= rightMax {
                return false
            }

            return isValid(node?.left, leftMax, node!.val) && isValid(node?.right, node!.val, rightMax)

        }

        return isValid(root, Int.min, Int.max)

    }
}
