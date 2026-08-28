class Solution {
    func isValid(_ s: String) -> Bool {

        let arr = Array(s)
        var stack = [Character]()

        for item in arr {
            if item == "[" || item == "(" || item == "{" {
                stack.append(item)
            } else {
                if stack.isEmpty {
                    return false
                }
                if stack.last == "{" && item != "}" {
                    return false
                } else if stack.last == "(" && item != ")" {
                    return false
                } else if stack.last == "[" && item != "]" {
                    return false
                }
                stack.removeLast()
            }
        }        
        return stack.count == 0
    }
}
