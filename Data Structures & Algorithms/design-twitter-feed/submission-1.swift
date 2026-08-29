class Twitter {
    private var count: Int
    private var tweetMap: [Int: [(Int, Int)]]  // userId -> list of (count, tweetId)
    private var followMap: [Int: Set<Int>]     // userId -> set of followeeId

    init() {
        self.count = 0
        self.tweetMap = [:]
        self.followMap = [:]
    }

    func postTweet(_ userId: Int, _ tweetId: Int) {
        tweetMap[userId, default: []].append((count, tweetId))
        count -= 1
    }

    func getNewsFeed(_ userId: Int) -> [Int] {
        var res = [Int]()
        var minHeap = Heap<Item>()

        followMap[userId, default: Set()].insert(userId)
        if let followees = followMap[userId] {
            for followee in followees {
                if let tweets = tweetMap[followee], !tweets.isEmpty {
                    let index = tweets.count - 1
                    let (cnt, tweetId) = tweets[index]
                    minHeap.insert(
                        Item(
                            count: cnt, tweetId: tweetId,
                            followeeId: followee, index: index - 1
                        )
                    )
                }
            }
        }

        while !minHeap.isEmpty && res.count < 10 {
            let entry = minHeap.popMin()!
            res.append(entry.tweetId)
            if entry.index >= 0, let tweets = tweetMap[entry.followeeId] {
                let (cnt, tweetId) = tweets[entry.index]
                minHeap.insert(
                    Item(
                        count: cnt, tweetId: tweetId,
                        followeeId: entry.followeeId, index: entry.index - 1
                    )
                )
            }
        }
        return res
    }

    func follow(_ followerId: Int, _ followeeId: Int) {
        followMap[followerId, default: Set()].insert(followeeId)
    }

    func unfollow(_ followerId: Int, _ followeeId: Int) {
        followMap[followerId]?.remove(followeeId)
    }
}

struct Item: Comparable {
    let count: Int
    let tweetId: Int
    let followeeId: Int
    let index: Int

    static func < (lhs: Item, rhs: Item) -> Bool {
        return lhs.count < rhs.count
    }

    static func == (lhs: Item, rhs: Item) -> Bool {
        return lhs.count == rhs.count
    }
}