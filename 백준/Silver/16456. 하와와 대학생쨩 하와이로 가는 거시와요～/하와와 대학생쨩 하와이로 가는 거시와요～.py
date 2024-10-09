# 섬은 n개로 일렬로 배치되어있다 --> lst 형식
# dp인가?? --> 1 1 2 3 4
# 아닌데 dp는 1 1 2 3 5인데 --> 혹시 dp[i-3] + dp[i-1] ????
# 어 섬6개 cnt=6 위의 점화식이 맞는건가?? 바로 테스트

# tc 1
    # 1 1 2 3 4 6

# 예제 입력 1을 해결 못함
# --> index out of range 조건문을 넣어서 해결??

import sys
input = sys.stdin.readline
n = int(input())

dp = [0] * (n+1)

dp[1] = 1
if n >= 2:
    dp[2] = 1
if n >= 3:
    dp[3] = 2

for i in range(4, n+1):
    dp[i] = dp[i-3] + dp[i-1]

print(dp[n]%1000000009)