class Solution {
    func findKthLargest(_ nums: [Int], _ k: Int) -> Int {

        var mutableNums = nums

        func swap(_ index: Int, _ index1: Int) {
            let temp = mutableNums[index]
            mutableNums[index] = mutableNums[index1]
            mutableNums[index1] = temp
        }

        var output: Int? = nil

        func quickSort(_ left: Int, _ right: Int) {

            if left > right {
                return
            }

            if output != nil {
                return
            }

            let pivotIndex = Int.random(in: left ... right)
            let pivotValue = mutableNums[pivotIndex]

            swap(pivotIndex, right)

            var start = left
            for i in left ..< right {
                if mutableNums[i] < pivotValue {
                    swap(start, i)
                    start += 1
                }
            }

            swap(start, right)

            if start == mutableNums.count - k {
                output = mutableNums[start]
                return
            }
            quickSort(left, start - 1)
            quickSort(start + 1, right)
        }

        quickSort(0, mutableNums.count - 1)

        return output ?? -1

    }
}
