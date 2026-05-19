class Solution {
    func dailyTemperatures(_ temperatures: [Int]) -> [Int] {
        var highestTemp = [(Int, Int)]()
        var output = [Int]()
        for i in stride(from: temperatures.count - 1, through: 0, by: -1) {
            var currentTemp = temperatures[i]
            if i == temperatures.count - 1 {
                output.append(0)
                highestTemp.append((currentTemp, i))
            } else {
                while highestTemp.count != 0 && highestTemp.last!.0 <= currentTemp {
                    highestTemp.removeLast()
                }
                if highestTemp.count != 0 {
                    output.insert(highestTemp.last!.1 - i, at: 0)
                } else {
                    output.insert(0, at: 0)
                }
                highestTemp.append((currentTemp, i))
            }
        }
        return output
    }
}