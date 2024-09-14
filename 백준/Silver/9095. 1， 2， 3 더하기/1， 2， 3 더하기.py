# 연산은 반드시 1,2,3 으로만 가능하다 그 위로는 안된다.
# 즉 순서쌍은 아래와 같다

# dp[1] 1개 = (1)
# dp[2] 2개 = (2), (1+1)
# dp[3] 4개 = (3), (1+2), (2+1), (1+1+1)
# dp[4] 7개 = (1+3), (3+1), (2+2), (1+1+2), (1+2+1), (2+1+1), (1+1+1+1)

# 점화식을 만들기 위해 N은 11까지만 적을 수 있으니, for 반복을 위해 12칸 만들자

import sys
input = sys.stdin.readline

dp = [0] * 12
dp[1] = 1
dp[2] = 2
dp[3] = 4

for i in range(4, 12):
    dp[i] = dp[i-1] + dp[i-2] + dp[i-3]

T = int(input())
for _ in range(T):
    n = int(input())
    print(dp[n])
