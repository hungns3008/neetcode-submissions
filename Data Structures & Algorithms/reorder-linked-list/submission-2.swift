/**
 * Definition for singly-linked list.
 * class ListNode {
 *     var val: Int
 *     var next: ListNode?
 *     init(_ val: Int) {
 *         self.val = val
 *         self.next = nil
 *     }
 * }
 */

class Solution {
    func reorderList(_ head: ListNode?) {

        func reverse(_ node: ListNode?) -> ListNode? {
            if node == nil {
                return node
            }
            var prev: ListNode? = nil
            var current = node
            while current != nil {
                let temp = current?.next
                current?.next = prev
                prev = current
                current = temp
            }
            return prev
        }

        var slow = head
        var fast = head
        while fast != nil && fast?.next != nil {
            slow = slow?.next
            fast = fast?.next?.next
        }

        var left = head
        var right = reverse(slow)

        while left !== right {
            var leftNext = left?.next
            var rightNext = right?.next

            left?.next = right
            right?.next = leftNext

            left = leftNext
            right = rightNext
        }



    }
}
