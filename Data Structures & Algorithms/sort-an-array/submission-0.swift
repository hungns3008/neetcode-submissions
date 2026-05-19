class Solution {
    func sortArray(_ nums: [Int]) -> [Int] {
        return mergeSort(nums, 0, nums.count - 1)
    }

    func mergeSort(_ arr: [Int], _ left: Int, _ right: Int) -> [Int] {
        if left > right {
            return []
        }
        if left == right {
            return [arr[left]]
        }
        var mid = (left + right) / 2
        let left = mergeSort(arr, left, mid)
        let right = mergeSort(arr, mid + 1, right)
        
        var output = [Int]()
        var i = 0
        var j = 0
        while i < left.count && j < right.count {
            if left[i] < right[j] {
                output.append(left[i])
                i += 1
            } else {
                output.append(right[j])
                j += 1
            }
        }
        while i < left.count {
            output.append(left[i])
            i += 1
        }

        while j < right.count {
            output.append(right[j])
            j += 1
        }
        return output
    }
}
