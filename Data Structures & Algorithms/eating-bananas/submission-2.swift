class Solution {
    func minEatingSpeed(_ piles: [Int], _ h: Int) -> Int {

        func canEat(_ banana: Int) -> Bool {
            var total = 0
            for p in piles {

                if p <= banana {
                    total += 1
                } else {
                    total += p / banana
                    if p % banana != 0 {
                        total += 1
                    }
                }

            }
            return total <= h
        }

        var maxBanana = piles[0]
        for p in piles {
            maxBanana = max(maxBanana, p)
        }
        var left = 1
        var right = maxBanana

        var output = right

        while left <= right {
            var mid = left + (right - left) / 2
            if canEat(mid) {
                output = min(output, mid)
                right = mid - 1
            } else {
                left = mid + 1
            }
        }

        return output
    }
    
}
