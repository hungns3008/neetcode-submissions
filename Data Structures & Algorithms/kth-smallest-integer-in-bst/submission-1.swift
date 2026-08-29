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
    func kthSmallest(_ root: TreeNode?, _ k: Int) -> Int {

        var output = -1
        var current = 0

        func inorder(_ node: TreeNode?) {
            if node == nil || output != -1 {
                return
            }
            inorder(node?.left)
            current += 1
            if current == k {
                output = node!.val
                return
            }
            inorder(node?.right)
        }

        inorder(root)

        return output

    }
}
