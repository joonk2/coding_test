from bisect import bisect_left
import sys
input = sys.stdin.readline
N= int(input())
arr = [0]+list(map(int, input().strip().split()))
dp = [0]*(N+1)
cmp = [-1000000001]
max_val = 0

# 1. 길이
for i in range(1, N+1):
    # BinarySearch로 저장된 값들은 정렬되므로 맨 뒤의 값과 비교
    if cmp[-1] < arr[i]: 
        cmp.append(arr[i])
        dp[i] = len(cmp)-1
        max_val = dp[i]
    else:
        # 현재 어느 값이 어느 위치의 값에 해당하는지 비교
        dp[i] = bisect_left(cmp, arr[i])
        # cmp 업데이트
        cmp[dp[i]] = arr[i] 

print(max_val)

# 2. 수열 & 백트랙킹
back_tracking = []
x = max(dp[1:])
for i in range(N, 0, -1):
    if dp[i] == max_val:
        back_tracking.append(arr[i])
        max_val -= 1

back_tracking.reverse()
print(*back_tracking)