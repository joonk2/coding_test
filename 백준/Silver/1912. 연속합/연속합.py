# https://www.youtube.com/watch?v=HvtAz_wo_S8
# [0] 10 -4 3 1 5 6 -35 12 21 -1
# 위는 [0]을 추가하여 인덱스 0 ~ 10인데 범위로 인덱스 1, n+1까지 조정가능

import sys

input = sys.stdin.readline
N = int(input())
seq = [0] + list(map(int, input().split()))  # 1부터 시작하도록 0을 추가

if max(seq[1:]) <= 0:
    ans = max(seq[1:])  # 음수만 있을 때 최대값
else:
    dp = [0] * (N + 1)  # N+1로 초기화
    dp[1] = seq[1]  
    for i in range(2, N + 1):
        dp[i] = max(seq[i], dp[i - 1] + seq[i])  # 연속합 계산
    ans = max(dp[1:])

print(ans)
