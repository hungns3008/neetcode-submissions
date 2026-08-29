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
    func mergeTwoLists(_ list1: ListNode?, _ list2: ListNode?) -> ListNode? {

        var node1 = list1
        var node2 = list2

        var prev = ListNode(-1)
        var current: ListNode? = prev

        while node1 != nil && node2 != nil {
            if node1!.val <= node2!.val {
                current?.next = ListNode(node1!.val)
                node1 = node1?.next
            } else {
                current?.next = ListNode(node2!.val)
                node2 = node2?.next
            }
            current = current?.next
        }

        if node1 != nil {
            current?.next = node1
        }
        if node2 != nil {
            current?.next = node2
        }

        return prev.next

    }
}
