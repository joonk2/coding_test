# dp[i][j]
# dp[i][0] 빨    dp[i][1] 초      dp[i][2]    파

# min?
# dp[0][0] dp[0][1] dp[0][2] 빨 초 파
# dp[1][0] dp[1][1] dp[1][2] 빨 초 파
# dp[2][0] dp[2][1] dp[2][2] 빨 초 파
# 근데 같은 색깔을 섞지는 못함 즉 min으로 가산할 때는 아무리 최소값이라도 크로스합만 가능

# 참 첫 행은 고정이다 ㅇㅋ?  즉 예제입력 1 기준으로 26 40 80 안건드린다고
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
