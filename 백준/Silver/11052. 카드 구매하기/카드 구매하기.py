def max_converter(N, p):
    dp = [0] * (N+1)

    for i in range(1, N+1):
        for j in range(1, i+1):
            dp[i] = max(dp[i], dp[i-j]+p[j])

    return dp[N]


N = int(input())
p = [0]+list(map(int, input().split()))

print(max_converter(N,p))