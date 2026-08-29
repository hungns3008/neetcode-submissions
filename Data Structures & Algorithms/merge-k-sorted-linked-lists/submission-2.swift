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
    func mergeKLists(_ lists: [ListNode?]) -> ListNode? {
        if lists.isEmpty { return nil }

        func merge(_ node1: ListNode?, _ node2: ListNode?) -> ListNode? {
            if node1 == nil { return node2 }
            if node2 == nil { return node1 }
            
            var n1: ListNode? = node1
            var n2: ListNode? = node2
            var temp = ListNode(1)
            var current: ListNode? = temp
            while n1 != nil && n2 != nil {
                if n1!.val <= n2!.val {
                    current?.next = n1
                    n1 = n1?.next 
                } else {
                    current?.next = n2
                    n2 = n2?.next 
                }
                current = current?.next
            }
            if n1 != nil {
                current?.next = n1
            }
            if n2 != nil {
                current?.next = n2
            }
            return temp.next
        }

        var currentLists = lists
        while currentLists.count > 1 {
            var temp = [ListNode?]()
            var i = 0
            while i < currentLists.count {
                let first = currentLists[i]
                let second = i + 1 < currentLists.count ? currentLists[i + 1] : nil
                temp.append(merge(first, second))
                i += 2
            }
            currentLists = temp
        }
        return currentLists[0]
    }
}