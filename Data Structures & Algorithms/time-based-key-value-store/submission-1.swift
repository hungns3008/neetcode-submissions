class TimeMap {

    var hash = [String: [(String, Int)]]() // key: [(value, timestamp)]

    init() {

    }

    func set(_ key: String, _ value: String, _ timestamp: Int) {
        if hash[key] == nil {
            hash[key] = []
        }
        hash[key]!.append((value, timestamp))
    }

    func get(_ key: String, _ timestamp: Int) -> String {

        if hash[key] == nil {
            return ""
        }

        var arr = hash[key]!
        var left = 0
        var right = arr.count - 1
        var res = ""

        while left <= right {
            var mid = (left + right) / 2
            if arr[mid].1 <= timestamp {
                res = arr[mid].0
                left = mid + 1
            } else {
                right = mid - 1
            }
        }

        return res

    }
}
