import sys
input = sys.stdin.readline

n = int(input())
wine = [0] * 10001

for i in range(1, n+1):
    wine[i] = int(input())

dp = [0] * 10001

dp[1] = wine[1]
dp[2] = wine[1] + wine[2]
dp[3] = max(dp[2], wine[1]+wine[3], wine[2]+wine[3])

for j in range(4, n+1):
    dp[j] = max(dp[j-3] + wine[j-1] + wine[j], dp[j-2] + wine[j], dp[j-1])
    # j = 4, 5 대입하면 코드가 100% 이해될 것이야


print(dp[n])
