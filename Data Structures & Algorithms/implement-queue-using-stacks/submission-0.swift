class MyQueue {

    var s1 = [Int]()
    var s2 = [Int]() 

    init() {

    }

    func push(_ x: Int) {
        s1.append(x)
    }

    func pop() -> Int {
        while s1.count != 0 {
            s2.append(s1.removeLast())
        }
        let result = s2.removeLast()
        while s2.count != 0 {
            s1.append(s2.removeLast())
        }
        return result
    }

    func peek() -> Int {
        while s1.count != 0 {
            s2.append(s1.removeLast())
        }
        let result = s2.last!
        while s2.count != 0 {
            s1.append(s2.removeLast())
        }
        return result
    }

    func empty() -> Bool {
        return s1.count == 0
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * let obj = MyQueue()
 * obj.push(x)
 * let param_2 = obj.pop()
 * let param_3 = obj.peek()
 * let param_4 = obj.empty()
 */
