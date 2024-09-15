# 생각해보자 기본 피보나치 수열 점화식 = dp[i] = dp[i-1] + dp[i-2]
# n은 40까지니 저장을 위해 최소 41칸 만들어주자

import sys
input = sys.stdin.readline
T = int(input())

for tc in range(T): # 테스트 케이스 개수만큼 반복
    n = int(input()) 

    dp_0 = [0] * 41 # 0이 호출되는 횟수를 저장할 list
    dp_1 = [0] * 41 # 1이 호출되는 횟수를 저장할 list
    dp_0[0] = 1     # fibonacci(0)을 호출했을 때 0이 호출되는 횟수 1
    dp_1[1] = 1     # fibonacci(1)을 호출했을 때 1이 호출되는 횟수 1

    for i in range(2, n + 1): 
        dp_0[i] = dp_0[i - 1] + dp_0[i - 2]
        dp_1[i] = dp_1[i - 1] + dp_1[i - 2]

    print(dp_0[n], dp_1[n])