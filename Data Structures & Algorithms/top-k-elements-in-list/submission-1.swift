class Solution {
    func topKFrequent(_ nums: [Int], _ k: Int) -> [Int] {
        var hash = [Int: Int]() // Number: Count
        for num in nums {
            hash[num] = (hash[num] ?? 0) + 1
        }

        struct NumberItem: Comparable {
            let data: [Int] // first index is the number, second index is the counter
            static func < (item1: NumberItem, item2: NumberItem) -> Bool {
                return item1.data[1] < item2.data[1]
            }
        }

        var maxHeap = Heap<NumberItem>()

        for (num, count) in hash {
            maxHeap.insert(NumberItem(data: [num, count]))
        }

        var output = [Int]()
        var mK = k
        while mK > 0 {
            if let item = maxHeap.popMax() {
                output.append(item.data[0])
            }
            mK -= 1
        }

        return output

    }
}
