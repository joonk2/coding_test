# dp[i][j]
# dp[i][0] 빨   dp[i][1] 초    dp[i][2] 파

# 색깔은 행이 바뀔 때마다 겹치면 안됨 --> 즉 크로스 합
# https://www.youtube.com/watch?v=QZXb1JWQ2Gc

import sys

input = sys.stdin.readline
N = int(input())
arr = [list(map(int, input().split())) for _ in range(N)]
dp = [[0] * 3 for _ in range(N)]
dp[0] = arr[0]

for i in range(N):
    dp[i][0] = min(dp[i-1][1], dp[i-1][2]) + arr[i][0]
    dp[i][1] = min(dp[i-1][0], dp[i-1][2]) + arr[i][1]
    dp[i][2] = min(dp[i-1][0], dp[i-1][1]) + arr[i][2]

print(min(dp[N-1]))