class Solution {
    func isNStraightHand(_ hand: [Int], _ groupSize: Int) -> Bool {
        if hand.count % groupSize != 0 {
            return false
        }

        var count = [Int: Int]()
        for num in hand {
            if count[num] == nil {
                count[num] = 0
            }
            count[num] = count[num]! + 1
        }

        for num in hand {
            var start = num
            while (count[start - 1] ?? 0) > 0 {
                start -= 1
            }
            while start <= num {
                while (count[start] ?? 0) > 0 {
                    for i in start..<(start + groupSize) {
                        if (count[i] ?? 0) == 0 {
                            return false
                        }
                        count[i]! -= 1
                    }
                }
                start += 1
            }
        }

        return true
    }
}
