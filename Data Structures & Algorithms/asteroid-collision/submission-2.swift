class Solution {
    func asteroidCollision(_ asteroids: [Int]) -> [Int] {
        var stack = [Int]()
        for a in asteroids {
            if stack.count == 0 {
                stack.append(a)
            } else {
                if stack.count != 0 && stack.last! > 0 && a < 0 {
                    var destroyed = false
                    while stack.count != 0 && stack.last! > 0 && a < 0 {
                        let diff = stack.last! + a
                        if diff == 0 {
                            stack.removeLast()
                            destroyed = true
                            break
                        } else if diff < 0 {
                            stack.removeLast()
                        } else {
                            destroyed = true
                            break
                        }
                    }
                    if !destroyed {
                        stack.append(a)
                    }
                } else {
                    stack.append(a)
                }
            }
        }
        return stack
    }
}