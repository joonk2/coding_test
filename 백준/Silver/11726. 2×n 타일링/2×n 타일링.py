# https://velog.io/@j3beom/%EB%B0%B1%EC%A4%80-11726%EB%B2%88-2xn-%ED%83%80%EC%9D%BC%EB%A7%81-Python-DP

import sys
input = sys.stdin.readline
n = int(input())

dp = [0] * 1001

dp[1] = 1
dp[2] = 2

for i in range(3, 1001):
    dp[i] = (dp[i-1] + dp[i-2]) % 10007

print(dp[n])
