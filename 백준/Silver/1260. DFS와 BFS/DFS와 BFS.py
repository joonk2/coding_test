from collections import deque
import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**3)

def dfs(V):
    dfs_v[V] = 1
    print(V, end= " ")
    for n in range(1, N+1):
        # dfs_v의 next_node를 방문 안했고 graph[V]의 다음 간선이 존재하면
        if dfs_v[n] == 0 and graph[V][n] == 1:
            dfs(n)


def bfs(V):
    q = deque([])
    q.append(V)
    bfs_v[V] = 1

    while q:
        V = q.popleft()
        print(V, end = " ")
        for n in range(1, N+1):
            # bfs_v의 next_node를 방문 안했고 graph[V]의 다음 간선이 존재하면
            if bfs_v[n] == 0 and graph[V][n] == 1:
                q.append(n)
                bfs_v[n] = 1


N, M, V = list(map(int, input().strip().split()))
graph = [[0]*(N+1) for _ in range(N+1)]
for _ in range(M):
    x, y = list(map(int, input().strip().split()))
    graph[x][y] = 1
    graph[y][x] = 1


dfs_v = [0]*(N+1)
bfs_v = [0]*(N+1)

dfs(V)
print()
bfs(V)