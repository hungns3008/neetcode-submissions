class MinStack {

    var stack = [Int]()
    var minStack = [Int]()

    init() {

    }

    func push(_ val: Int) {
        stack.append(val)
        if minStack.count == 0 {
            minStack.append(val)
        } else {
            minStack.append(min(minStack.last!, val))
        }
    }

    func pop() {
        stack.removeLast()
        minStack.removeLast()
    }

    func top() -> Int {
        return stack.last!
    }

    func getMin() -> Int {
        return minStack.last!
    }
}
