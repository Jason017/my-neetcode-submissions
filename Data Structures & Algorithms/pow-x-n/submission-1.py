class Solution:
    def myPow(self, x: float, n: int) -> float:
        if n == 1:
            return x
        if n == -1:
            return 1 / x
        if n == 0:
            return 1
            
        xx = self.myPow(x, n // 2)
        if n % 2 == 0:
            return xx * xx
        if n % 2 == 1:
            return xx * xx * x