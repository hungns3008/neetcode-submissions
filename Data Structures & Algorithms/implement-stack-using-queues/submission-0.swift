class MyStack {

    var q1 = [Int]() // 1
    var q2 = [Int]() // 3 2 1
    // 1 2 3 4 5

    init() {

    }

    func push(_ x: Int) {
        q1.append(x)
        while q2.count != 0 {
            q1.append(q2.removeFirst())
        }
        q2 = q1
        q1 = []
    }

    func pop() -> Int {
        return q2.removeFirst()
    }

    func top() -> Int {
        return q2.first ?? -1
    }

    func empty() -> Bool {
        return q2.count == 0
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * let obj = MyStack()
 * obj.push(x)
 * let param_2 = obj.pop()
 * let param_3 = obj.top()
 * let param_4 = obj.empty()
 */
