import sys
input = sys.stdin.readline

N = int(input())
arr = [0] + list(map(int, input().strip().split()))
increase_dp = [1] * (N+1)
decrease_dp = [1] * (N+1)

# 1. 증가 수열
for i in range(1, N+1):
    for j in range(1, i):
        if arr[i] > arr[j]:
            increase_dp[i] = max(increase_dp[i], increase_dp[j]+1)


# 2. 감소 수열
for i in range(N, 0, -1):
    for j in range(i+1, N+1):
        if arr[i] > arr[j]:
            decrease_dp[i] = max(decrease_dp[i], decrease_dp[j]+1)


# 3. 출력
res = [0] * (N+1)
for r in range(1, N+1):
    # 겹치는 값 제외하기 위해 -1
    res[r] = increase_dp[r] + decrease_dp[r]-1
print(max(res))
