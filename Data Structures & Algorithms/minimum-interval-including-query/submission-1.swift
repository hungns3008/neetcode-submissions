class Solution {
    func minInterval(_ intervals: [[Int]], _ queries: [Int]) -> [Int] {

        struct Item: Comparable {
            let size: Int
            let end: Int
            static func < (i1: Item, i2: Item) -> Bool {
                if i1.size == i2.size {
                    return i1.end < i2.end
                }
                return i1.size < i2.size
            }
        }

        let sortedIntervals = intervals.sorted { a, b in a[0] < b[0] }
        var minHeap = Heap<Item>()
        var res = [Int: Int]() // query: size
        var i = 0

        for q in queries.sorted() {
            while i < sortedIntervals.count && sortedIntervals[i][0] <= q {
                let l = sortedIntervals[i][0]
                let r = sortedIntervals[i][1]
                minHeap.insert(Item(size: r - l + 1, end: r))
                i += 1
            }
            while minHeap.count > 0 && minHeap.min!.end < q {
                minHeap.removeMin()
            }
            res[q] = minHeap.count == 0 ? -1 : minHeap.min!.size
        }

        return queries.map { q in res[q] ?? -1 }

    }
}
