class Solution {
    func countSubstrings(_ s: String) -> Int {

        var counter = 0

        let arr = Array(s)

        func count(_ l: Int, _ r: Int) {
            var left = l
            var right = r
            while left >= 0 && right < arr.count && arr[left] == arr[right] {
                left -= 1
                right += 1
                counter += 1
            } 
        }

        for i in 0 ..< s.count {
            count(i, i)
            count(i, i + 1)
        }

        return counter

    }
}
