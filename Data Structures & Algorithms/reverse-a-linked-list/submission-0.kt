/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun reverseList(head: ListNode?): ListNode? {
        var prev: ListNode? = null
        var h = head
        while (h != null) {
            val temp = h?.next
            h?.next = prev
            prev = h
            h = temp
        }
        return prev
    }
}
