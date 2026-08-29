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
    func removeNthFromEnd(_ head: ListNode?, _ n: Int) -> ListNode? {
        var temp = ListNode(1)
        temp.next = head
        var slow: ListNode? = temp
        var fast: ListNode? = temp
        for i in 0 ..< n {
            fast = fast?.next
        }
        while fast != nil && fast?.next != nil {
            slow = slow?.next
            fast = fast?.next
        }
        slow?.next = slow?.next?.next
        return temp.next
    }
}
