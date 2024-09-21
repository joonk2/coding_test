import sys
input = sys.stdin.readline
n = int(input())
wine = [0] * 10001

for i in range(1, n+1):
    wine[i] = int(input())

dp = [0] * 10001
dp[1] = wine[1]
dp[2] = wine[1] + wine[2]
dp[3] = max(wine[1]+wine[3], wine[2]+wine[3], wine[1]+wine[2])

for j in range(4, n+1):
    dp[j] = max(dp[j-3] + wine[j-1] + wine[j], dp[j-2]+wine[j], dp[j-1])


print(dp[n])