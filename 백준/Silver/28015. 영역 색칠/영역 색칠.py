from collections import deque
import sys
input = sys.stdin.readline

N, M = list(map(int, input().strip().split()))
arr = [list(map(int, input().strip().split())) for _ in range(N)]
# print(arr)




def get_min(stack):
    row1 = 0
    cnt1 = 0
    row2 = 0
    cnt2 = 0
    
    if not stack:
        return 0
    
    while stack:
        v = stack.pop()
        if v == 1:
            if row1 > 0:
                cnt1 += 1
            row1 = 0
            row2 += 1
        else:
            row1 += 1
            if row2 > 0:
                cnt2 += 1
            row2 = 0
    
    if row1 != 0:
        cnt1 += row1
    if row2 != 0:
        cnt2 += row2
    
    return min(cnt1, cnt2) + 1

res = 0
for i in range(N):
    stack = []  
    cnt = 0
    for j in range(M):
        if arr[i][j] == 0:
            cnt += get_min(stack)
        else:
            stack.append(arr[i][j])
    
    if stack:
        cnt += get_min(stack)
    
    res += cnt

print(res)