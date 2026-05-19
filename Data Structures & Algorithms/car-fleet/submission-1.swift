class Solution {
    func carFleet(_ target: Int, _ position: [Int], _ speed: [Int]) -> Int {
        var cars = [(Int, Int)]()

        for i in 0 ..< position.count {
            cars.append((position[i], speed[i]))
        }

        cars.sort {
            $0.0 < $1.0
        }

        var output = [Float]()

        for i in stride(from: cars.count - 1, through: 0, by: -1) {
            let car = cars[i]
            let position = car.0
            let speed = car.1
            let time = Float(target - position) / Float(speed)
            if output.count == 0 {
                output.append(time)
            } else {
                let lastTime = output.last!
                if lastTime < time {
                    output.append(time)
                } 
            }
        }

        return output.count
    }
}
