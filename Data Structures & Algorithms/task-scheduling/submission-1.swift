class Solution {
    func leastInterval(_ tasks: [Character], _ n: Int) -> Int {
        // maxHeap // task: counter
        struct Task: Comparable {
            var task: Character
            var count: Int
            static func < (t1: Task, t2: Task) -> Bool {
                return t1.count < t2.count
            }
        }
        var hash = [Character: Int]()
        for task in tasks {
            hash[task] = (hash[task] ?? 0) + 1
        }
        var maxHeap = Heap<Task>()
        for (task, count) in hash {
            maxHeap.insert(Task(task: task, count: count))
        }
        var queue = [(Character, Int, Int)]() // task, count, cycle
        var currentCycle = 0

        while queue.count > 0 || maxHeap.count > 0 {
            currentCycle += 1
            if maxHeap.count == 0 {
                currentCycle = queue.first!.2
            } else {
                var task = maxHeap.popMax()!
                var count = task.count - 1
                if count > 0 {
                    queue.append((task.task, count, currentCycle + n))
                }
            }
            if let front = queue.first, front.2 == currentCycle {
                maxHeap.insert(Task(task: front.0, count: front.1))
                queue.removeFirst()
            }
        }

        return currentCycle

    }
}
