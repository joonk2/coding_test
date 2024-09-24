# 입출력1 출발지점(맨 오른쪽 밑에서부터)

# [
#   [0, 0, 0, 0, 0, 0],
#   [0, 0, 0, 0, 0, 0],
#   [0, 0, 0, 0, 0, 0],
#   [0, 0, 0, 0, 0, 1]
# ]

# 입출력1 도착지점

# [
#   [9, 8, 7, 6, 5, 4],
#   [8, 7, 6, 5, 4, 3],
#   [7, 6, 5, 4, 3, 2],
#   [6, 5, 4, 3, 2, 1]
# ]


# 입출력2 출발지점(맨 오른쪽 밑에서부터)

# [
#   [1, -1, 0, 0, 0, 0],
#   [0, -1, 0, 0, 0, 0],
#   [0, 0, 0, 0, -1, 0],
#   [0, 0, 0, 0, -1, 1]
# ]



# 입출력2 도착지점

# [
#     [1,-1,7,6,5,4],
#     [2,-1,8,7,4,3],
#     [3,4,7,8,-1,2],
#     [4,5,6,7,-1,1]
# ]



# bfs 함수
from collections import deque

def bfs():
    v = [ [0] * m for _ in range(n)]
    q = deque([])

    # 첫 노드
    for i in range(n):
        for j in range(m):
            if graph[i][j] == 1:
                q.append((i,j))

    while q:
        x, y = q.popleft()

        # 4방향
        dx = [-1,1,0,0]
        dy = [0,0,-1,1]
        
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]

            if 0 <= nx < n and 0 <= ny < m and graph[nx][ny] == 0:
                q.append((nx, ny))
                graph[nx][ny] = graph[x][y] + 1
                v[nx][ny] = 1




# 1. 첫줄 입력, 둘째줄 입력, bfs함수 실행
m, n = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(n)]
bfs()

# 2. 결과 출력
# 만약, 저장될 때부터 모든 토마토가 익어있는 상태이면 0을 출력해야 하고,
# 토마토가 모두 익지는 못하는 상황이면 -1을 출력

result = 0
for i in range(n):
    for j in range(m):
        if graph[i][j] == 0:
            print(-1)
            exit(0)
        result = max(result, graph[i][j])

print(result-1)
