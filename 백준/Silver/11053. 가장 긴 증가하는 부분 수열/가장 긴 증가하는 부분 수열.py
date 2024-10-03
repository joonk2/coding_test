#  A = {10, 20, 10, 30, 20, 50} 
# 현재값과 이전 값을 비교해 각 자리마다 cnt를 적용해주자
# 만약 현재값 < 이전값이라면 다시 위로 for문 순회하자
# --> [1,2, ,3, ,4]
# 최종적으로는 max값 출력

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
