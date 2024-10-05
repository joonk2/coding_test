import sys
input = sys.stdin.readline

N = int(input())
arr = [0] + list(map(int, input().strip().split()))
dp = [0] * (N+1)

# 1. 길이
for i in range(1, N+1):
    for j in range(i):
        if arr[i] > arr[j]:
            dp[i] = max(dp[i], dp[j]+1)
print(max(dp[1:]))


# 2. 수열 & 역추적
back_tracking = []
x = max(dp[1:])
for i in range(N, 0, -1):
    if dp[i] == x:
        back_tracking.append(arr[i])
        x -= 1

back_tracking.reverse()
print(*back_tracking)