import sys
input = sys.stdin.readline

n = int(input())
dp = [0] * (n+1)
dp[0] = 0
dp[1] = 1

def fibonacci(n):
    for i in range(2, n+1):
        dp[i] = dp[i-2] + dp[i-1]

    return dp[n]

print(fibonacci(n))