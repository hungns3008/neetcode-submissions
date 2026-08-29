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
    func buildTree(_ preorder: [Int], _ inorder: [Int]) -> TreeNode? {
        // preorder: rLR
        // inorder = LrR

        var hash = [Int: Int]() // number: index

        for i in 0 ..< inorder.count {
            hash[inorder[i]] = i
        }

        var currentIndex = 0

        func buildNode(_ left: Int, _ right: Int) -> TreeNode? {
            if left > right {
                return nil
            }
            var rootValue = preorder[currentIndex]
            var root = TreeNode(rootValue)
            var rootIndex = hash[rootValue]!
            currentIndex += 1

            root.left = buildNode(left, rootIndex - 1)
            root.right = buildNode(rootIndex + 1, right)
            return root
        }

        return buildNode(0, preorder.count - 1)
    }
}
