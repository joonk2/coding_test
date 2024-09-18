# https://www.youtube.com/watch?v=ATs2_KiBV2E

# import sys
# sys.stdin = open("input.txt", "r")

def bfs(start_i, start_j, end_i, end_j):
    queue = []
    visited = [[0] * M for _ in range(N)]

    queue.append((start_i, start_j))
    visited[start_i][start_j] = 1 # 방문 표시

    while queue:
        current_i, current_j = queue.pop(0)
        if (current_i, current_j) == (end_i, end_j): # 현재가 목적지 좌표라면
            return visited[end_i][end_j]

        # 4방향 범위내, 조건에 맞으면 queue에 삽입
        for direction_i, direction_j in ((-1,0), (1,0), (0,-1), (0,1)): #상하좌우
            next_i, next_j = current_i + direction_i, current_j + direction_j
            if 0 <= next_i < N and  0 <= next_j < M and arr[next_i][next_j] == 1 and visited[next_i][next_j] == 0:
                # 만약 다음 좌표의 행과 열이 입력한 범위 내에 있고, 길이 있으며(=1), 방문하지 않았는 곳이라면(=0)
                queue.append((next_i, next_j))
                visited[next_i][next_j] = visited[current_i][current_j]+1

N,M = map(int, input().split())
arr = [list(map(int, input())) for _ in range(N)]

ans = bfs(0, 0, N-1, M-1)
print(ans)