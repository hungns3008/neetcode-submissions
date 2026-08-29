class Solution {
    func kClosest(_ points: [[Int]], _ k: Int) -> [[Int]] {

        struct Point: Comparable {
            var x: Int
            var y: Int
            var distance: Double

            static func < (point1: Point, point2: Point) -> Bool {
                return point1.distance < point2.distance
            }
        }

        func distanceToOrigin(_ x: Int, _ y: Int) -> Double {
            return sqrt(Double(x * x) + Double(y * y))
        }

        var maxHeap = Heap<Point>()

        for point in points {
            var x = point[0]
            var y = point[1]
            var distance = distanceToOrigin(x, y)
            var p = Point(x: x, y: y, distance: distance)
            maxHeap.insert(p)
            if maxHeap.count > k {
                maxHeap.popMax()
            }
        }

        var output = [[Int]]()

        while maxHeap.count > 0 {
            var p = maxHeap.popMax()!
            output.append([p.x, p.y])
        }

        return output

    }
}
