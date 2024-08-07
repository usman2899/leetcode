class Solution(object):
    def strStr(self, haystack, needle):
        if len(needle) > len(haystack):
            return -1
        for idxHay, charHay in enumerate(haystack):
            if (len(haystack) - idxHay) < len(needle):
                return -1
            for idxNee, charNee in enumerate(needle):
                if haystack[idxHay+idxNee] != charNee:
                    break
                if idxNee == len(needle)-1:
                    return idxHay
        return -1
        