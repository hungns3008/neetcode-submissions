class Solution {
    func checkInclusion(_ s1: String, _ s2: String) -> Bool {
        if s1.count > s2.count {
            return false
        }
        var arr1 = Array(s1)
        var arr2 = Array(s2)

        var hash = [Character: Int]()
        for s in arr1 {
            hash[s] = (hash[s] ?? 0) + 1
        }
        var counter = hash.count
        var left = 0
        var right = 0
        while right < arr2.count {
            if hash[arr2[right]] != nil {
                hash[arr2[right]] = hash[arr2[right]]! - 1
                if hash[arr2[right]]! == 0 {
                    counter -= 1
                } 
                while counter == 0 {
                    if right - left + 1 == arr1.count {
                        return true
                    }
                    if hash[arr2[left]] != nil {
                        hash[arr2[left]] = hash[arr2[left]]! + 1
                        if hash[arr2[left]]! > 0 {
                            counter += 1
                        }
                    }
                    left += 1

                }
            }
            right += 1
        }

        return false
    }
}
