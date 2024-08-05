class Solution(object):
    def twoSum(self, nums, target):
        dict = {}
        for idx, num in enumerate(nums):
            diff = target - num
            if (diff in dict):
                return [idx, dict[diff]]
            else:
                dict[num] = idx
        