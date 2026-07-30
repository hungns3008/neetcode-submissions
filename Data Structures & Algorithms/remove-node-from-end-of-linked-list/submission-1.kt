/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        var temp = ListNode(-1)
        temp.next = head

        var slow: ListNode? = temp
        var fast: ListNode? = temp
        for (i in 0 until n) {
            fast = fast?.next
        }
        while (fast != null && fast?.next != null) {
            slow = slow?.next
            fast = fast?.next
        }
        slow?.next = slow?.next?.next
        
        return temp.next
    }
}
