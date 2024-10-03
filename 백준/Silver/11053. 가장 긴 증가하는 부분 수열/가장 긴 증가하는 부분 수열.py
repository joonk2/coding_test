#  A = {10, 20, 10, 30, 20, 50} 
# 전의 값과 비교해서 커진 값만 추가

import sys
input = sys.stdin.readline
N = int(input())

arr = [0] + list(map(int, input().strip().split()))
dp = [0] * (N+1)


# 1. 이전값 비교 알고리즘
for i in range(1, N+1):
    for j in range(i):
        if arr[i] > arr[j]:
            dp[i] = max(dp[i], dp[j]+1)

# 2. 중간에 최대값이 있을 수도 있기에 max 값 찾기 필수
print(max(dp))