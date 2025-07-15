class Solution:
    # @param A : string
    # @param B : string
    # @return an integer
    def permuteStrings(self, A, B):
        dicA = {}
        dicB = {}
        for ch in A:
            if ch in dicA.keys():
                dicA[ch] += 1
            else:
                dicA[ch] = 1
        for ch in B:
            if ch in dicB.keys():
                dicB[ch] += 1
            else:
                dicB[ch] = 1
        count = 0 
        dicA, dicB = (dicA, dicB) if len(dicA) < len(dicB) else (dicB, dicA)
        for ch in A:
            if ch in B and dicA[ch] == dicB[ch]:
                count+=1
        if count == len(dicA):
            return 1
        return 0