class Solution:
    def eraseOverlapIntervals(self, intervals: List[List[int]]) -> int:
        def sortSecond(val):
            return val[1]
        
        intervals.sort(key=sortSecond)
        res = 0
        currEnd = intervals[0][1]
        
        for start, end in intervals[1:]:
            if start < currEnd:
                res += 1
            else:
                currEnd = end
            
        return res
        