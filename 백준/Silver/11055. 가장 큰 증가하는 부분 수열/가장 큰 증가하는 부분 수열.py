# 10
# 1 100 2 50 60 3 5 6 7 8
# 이 입출력 예제보면 1,2,50,60 이 선택되어 답은 113

# 우선 각 자리마다 구한 배열 dp[1:]은 아래와 같다
# [1, 101, 3, 53, 113, 6, 11, 17, 24, 32]

import sys
input = sys.stdin.readline

N = int(input())
arr = [0] + list(map(int, input().strip().split()))
dp = [0] * (N+1)
dp[1] = arr[1]

for i in range(2, N+1):
    for j in range(i):
        if arr[i] > arr[j]:
            dp[i] = max(dp[i], dp[j]+arr[i])

print(max(dp))
