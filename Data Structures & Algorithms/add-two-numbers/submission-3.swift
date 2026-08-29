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
    func addTwoNumbers(_ l1: ListNode?, _ l2: ListNode?) -> ListNode? {
        var c1: ListNode? = l1
        var c2: ListNode? = l2
        var output = ListNode(-1)
        var current: ListNode? = output
        var remaining = 0
        while c1 != nil && c2 != nil {
            let sum = c1!.val + c2!.val + remaining
            remaining = sum / 10
            current?.next = ListNode(sum % 10)
            current = current?.next
            c1 = c1?.next
            c2 = c2?.next
        }
        while c1 != nil {
            let sum = c1!.val + remaining
            remaining = sum / 10
            current?.next = ListNode(sum % 10)
            current = current?.next
            c1 = c1?.next
        }

        while c2 != nil {
            let sum = c2!.val + remaining
            remaining = sum / 10
            current?.next = ListNode(sum % 10)
            current = current?.next
            c2 = c2?.next
        }

        if remaining != 0 {
            current?.next = ListNode(remaining)
        }

        return output.next
    }
}
