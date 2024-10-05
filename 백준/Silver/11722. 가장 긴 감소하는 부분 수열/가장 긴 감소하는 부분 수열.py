# 답은 [0] + [1,1,2,2,2,3] --> 3

N = int(input())
arr = [0] + list(map(int, input().strip().split()))
dp = [1] * (N+1)


for i in range(1, N+1):
    for j in range(i):
        if arr[i] < arr[j]:
            dp[i] = max(dp[i], dp[j]+1)

print(max(dp[1:]))
