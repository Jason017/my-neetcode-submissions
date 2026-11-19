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
        pairs = []
        for i in intervals:
            pairs.extend([(i.start, 1), (i.end, -1)])
            
        pairs.sort()
        mx, ans = 0, 0

        for _,  cost in pairs:
            mx += cost
            ans = max(ans, mx)
        return ans
        
