# 계단의 각 칸은 1,2,3,4,5,6
# 한 계단 or 두 계단
# 계단 갯수 <= 300
# 4 번째 계단 밟기 --> 124, 134, 24
# https://daimhada.tistory.com/181

import sys
input = sys.stdin.readline
N = int(input())

stairs = [0] * 301

for i in range(1, N+1):
    stairs[i] = int(input())

dp = [0] * 301
# 1칸, 2칸, 3칸
dp[1] = stairs[1]
dp[2] = stairs[1] + stairs[2]
dp[3] = max(stairs[1]+stairs[3], stairs[2]+stairs[3])

for j in range(4, N+1):
    dp[j] = max(dp[j-3]+stairs[j-1]+stairs[j], dp[j-2]+stairs[j])
    # j=5 대입해보면 바로 모든 과정이 이해가 된다

print(dp[N])
