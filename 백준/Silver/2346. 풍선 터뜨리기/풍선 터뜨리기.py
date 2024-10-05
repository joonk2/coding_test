import sys
from collections import deque

input = sys.stdin.readline
N = int(input())
q = deque(enumerate(map(int, input().split()), 1))
res = []

while q:
    i, move = q.popleft() # 풍선 번호와 이동할 칸 수
    res.append(i) # 터뜨린 풍선 번호를 결과에 추가

    if move > 0:
        q.rotate(-(move-1)) # 양수면 move-1만큼 왼쪽으로 회전
    else:
        q.rotate(-move) # 음수면 그대로 그만큼 오른쪽으로 회전 

print(' '.join(map(str, res)))