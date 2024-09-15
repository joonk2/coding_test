# 생각해보자 기본 피보나치 수열 점화식 = dp[i] = dp[i-1] + dp[i-2]
# n은 40까지니 저장을 위해 최소 41칸 만들어주자
# 내는 바텀업 방식 사용할게 --> 그래서 모든 칸 0으로 초기화하고 만든다
# 암튼 문제는 "Fibonacci(N) 호출했을 때, 0과 1 각각 몇 번 출력인지 구해라"다

#              Fibo(3)
#             /      \
#       Fibo(2)     Fibo(1)
#         /    \
#   Fibo(1)   Fibo(0)

# Fibonacci = 3일때는 F(0) 1번,   F(1) 2번 출력하네

import sys
input = sys.stdin.readline
T = int(input())

for i in range(T):
    dp_0 = [0] * 41
    dp_1 = [0] * 41
    dp_0[0] = 1
    dp_1[1] = 1
    
    n = int(input())

    for j in range(2, n+1):
        dp_0[j] = dp_0[j-1] + dp_0[j-2]
        dp_1[j] = dp_1[j-1] + dp_1[j-2]
    
    print(dp_0[n], dp_1[n])
