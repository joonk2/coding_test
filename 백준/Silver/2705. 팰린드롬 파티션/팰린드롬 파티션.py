'''
1 -> 1개
2 -> 2개 
3 -> 2개
4 -> 4개 
5 -> 4개
6 -> 6개
7 -> 6개

홀
짝
'''

import sys
input = sys.stdin.readline

dp = [0] * (1001)
dp[1] = 1

for i in range(2, 1001):
    if i % 2 == 1:
        dp[i] = dp[i-1]
    else:
        dp[i] = dp[i-1] + dp[i//2]


T = int(input())
for _ in range(T):
    n = int(input())
    print(dp[n])