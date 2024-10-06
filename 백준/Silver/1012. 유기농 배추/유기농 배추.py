# 문제 풀기 전에 조건 정리

# 상하좌우 --> bfs or dfs?
# 0은 배추가 심어져 있지 않은 땅
# 1은 배추가 심어져 있는 땅
# 문제 예시를 보면 지렁이 5마리 필요 --> 아 대각선 이동은 불가능 하구나
# --> 찾아야 할 답은 최소 지렁이 마릿수



import sys
from collections import deque
input = sys.stdin.readline
sys.setrecursionlimit(10**6)


# 2. dfs
def dfs(graph, x, y):
    graph[x][y] = 0

    for dx, dy in ((-1, 0), (1, 0), (0, -1), (0, 1)):
        nx = x+dx
        ny = y+dy

        if 0 <= nx < M and 0 <= ny < N and graph[nx][ny] == 1:
            dfs(graph, nx, ny)


# 1. 입출력
    # 1-1. TC갯수
    # 1-2. M, N, K
    # 1-3. TC별 빈 그래프 초기화
    # 1-4. 배추 흰지렁이 마릿수
    # 1-5. tc별로 배추 심은 위치 좌표 입력하기

T = int(input())

for _ in range(T):
    cnt_worm = 0
    M, N, K = list(map(int, input().strip().split()))
    graph = [[0]*N for _ in range(M)]

    for _ in range(K):
        X, Y = list(map(int, input().strip().split()))
        graph[X][Y] = 1

    for i in range(M):
        for j in range(N):
            if graph[i][j] == 1:
                dfs(graph, i, j)
                cnt_worm += 1
    print(cnt_worm)