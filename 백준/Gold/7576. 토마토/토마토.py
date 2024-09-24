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



from collections import deque

# 3. 함수

def bfs():
    q = deque([])
    v = [[0] * m for _ in range(n)]
    
    # 방향
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]

    # 익은 토마토들의 위치를 모두 큐에 넣고 시작
    for i in range(n):
        for j in range(m):
            if graph[i][j] == 1:
                q.append((i, j))
    
    # 큐가 차있을 때
    while q:
        x, y = q.popleft()
        
        # 4방향
        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]

            if 0 <= nx < n and 0 <= ny < m and graph[nx][ny] == 0 and v[nx][ny] == 0:
                q.append((nx, ny))
                graph[nx][ny] = graph[x][y] + 1  # 날짜 증가
                v[nx][ny] = 1  # 방문 처리



# 1. 입력, 함수

m, n = map(int, input().split())
graph = [list(map(int, input().split())) for _ in range(n)]
bfs() # bfs 탐방


# 2. 출력 

# 만약 bfs 탐방 후에도 익지 않은 토마토가 남아있다면
result = 0
for i in range(n):
    for j in range(m):
        if graph[i][j] == 0: 
            print(-1)
            exit(0)
        result = max(result, graph[i][j])  # 최대 일수 계산

# 시작이 1이었으므로 1을 빼줌
print(result - 1)
