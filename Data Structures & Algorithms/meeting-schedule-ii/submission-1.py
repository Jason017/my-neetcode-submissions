"""
Definition of Interval:
class Interval(object):
    def __init__(self, start, end):
        self.start = start
        self.end = end

0                 40
   5 10   15 20

0  5  15
10 20 40


"""

class Solution:
    def minMeetingRooms(self, intervals: List[Interval]) -> int:
        times = []
        for i in intervals:
            times.append((i.start, 1))
            times.append((i.end, -1))

        times.sort(key = lambda i: (i[0],i[1]))
        res = curr = 0

        for time in times:
            curr += time[1]
            res = max(curr, res)

        return res
        
