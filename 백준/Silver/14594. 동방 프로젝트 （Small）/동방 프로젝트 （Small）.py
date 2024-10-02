# 1. 각 방의 상태를 초기화하자(1이면 방이 존재), 늘 그렇지만 인덱스 0은 쓰지 않는다
# --> 이게 1번 방의 왼쪽 벽을 무너뜨리지 않는다는 말인가
# 2. 벽이 허물어지면 0으로 저장 --> 방이 연결됨
# 3. 맨 왼쪽벽(0번), 맨 오른쪽 N+1 벽(N번) 허물지 않게 구현됨

import sys
input = sys.stdin.readline

N = int(input())  # 방의 개수
M = int(input())  # 빌런의 행동 횟수

wall = [1] * (N + 1)  

for _ in range(M):
    x, y = map(int, input().split())
    # 벽을 허물면서 방의 상태를 변경
    for j in range(x, y):
        wall[j] = 0  


# 방 갯수 cnt
cnt = 0
for d in range(1, N + 1):
    if wall[d] == 1:
        cnt += 1

print(cnt)  