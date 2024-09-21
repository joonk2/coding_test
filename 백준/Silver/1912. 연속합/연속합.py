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