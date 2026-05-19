class Solution {
    func evalRPN(_ tokens: [String]) -> Int {
        var stack = [Int]()
        for token in tokens {
            if token != "+" && token != "-" && token != "*" && token != "/" {
                stack.append(Int(token)!)
            } else {
                let second = stack.removeLast()
                let first = stack.removeLast()
                if token == "+" {
                    stack.append(first + second)
                } else if token == "-" {
                    stack.append(first - second)
                } else if token == "*" {
                    stack.append(first * second)
                } else {
                    stack.append(first / second)
                }
            }
        }
        return stack[0]
    }
}
