import sys
from collections import deque
input = sys.stdin.readline




def bfs(K, W, H, map):
    dx = [0, 0, 1, -1]
    dy = [1, -1, 0, 0]
    horse_dx = [-2, -1, 1, 2, 2, 1, -1, -2]
    horse_dy = [1, 2, 2, 1, -1, -2, -2, -1]

    # 방문 여부 체크 (x, y, 남은 말의 움직임 수)
    v = [[[0] * (K + 1) for _ in range(W)] for _ in range(H)]
    
    q = deque([])
    q.append((0,0,0,0))
    v[0][0][0] = 1

    while q:
        x, y, horseMoves, moves = q.popleft()

        if x == H - 1 and y == W - 1:
            return moves

        for i in range(4):
            nx, ny = x + dx[i], y + dy[i]

            if 0 <= nx < H and 0 <= ny < W and v[nx][ny][horseMoves] == 0 and map[nx][ny] == 0:
                v[nx][ny][horseMoves] = 1
                q.append((nx, ny, horseMoves, moves + 1))

        # 말의 이동
        if horseMoves < K:
            for i in range(8):
                nx, ny = x + horse_dx[i], y + horse_dy[i]

                if 0 <= nx < H and 0 <= ny < W and not v[nx][ny][horseMoves + 1] and map[nx][ny] == 0:
                    v[nx][ny][horseMoves + 1] = 1
                    q.append((nx, ny, horseMoves + 1, moves + 1))

    # 도착할 수 없는 경우
    return -1  




K = int(input())
W, H = map(int, input().split())
map = [list(map(int, input().split())) for _ in range(H)]
print(bfs(K, W, H, map))