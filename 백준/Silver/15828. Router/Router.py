# import sys
# input = sys.stdin.readline
# N,K,B = list(map(int, input().strip().split()))

# traffic_light = [0]*(N+1)
# broken = [int(input()) for _ in range(B)]
# broken.sort()

# for i in broken:
#     traffic_light[broken[i]] = -1

# current_broken = 0
# for i in range(1, K+1):
#     if traffic_light[i] == -1:
#         current_broken += 1

# min_fix = current_broken
# for j in range()

from collections import deque
import sys
input = sys.stdin.readline
N = int(input())
q = deque([])

while True:
    data = int(input())

    if data == -1:
        break    

    if data == 0:
        q.popleft()
    elif len(q) < N:
        q.append(data)


if q:
    print(*q)
else:
    print('empty')