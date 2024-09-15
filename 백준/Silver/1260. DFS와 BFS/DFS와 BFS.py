# 순서
# 1. 그래프를 0으로 채우고, 방문을 전부 False로 채운다 
# 2. 그래프 정보를 입력한다
# 3. DFS 코드 짠다
# 4. BFS 작동을 위해 다시 visited 초기화 하고 bfs 코드 짜자

from collections import deque

N, M, V = map(int, input().split())

graph = [[False] * (N + 1) for _ in range(N + 1)]

for _ in range(M):
    a, b = map(int, input().split())
    graph[a][b] = True
    graph[b][a] = True

dfs_visited = [False] * (N + 1)  # dfs의 방문기록
bfs_visited = [False] * (N + 1)  # bfs의 방문기록


def dfs(V):
    dfs_visited[V] = True  # 해당 V값 방문처리
    print(V, end=" ")
    for next_node in range(1, N + 1):
        if not dfs_visited[next_node] and graph[V][next_node]:  # 만약 next_node를 방문하지 않았고, 연결이 되어있다면
            dfs(next_node)  # 해당 next_node로 dfs를 돈다.(더 깊이 탐색)




def bfs(V):
    q = deque([V])  # pop메서드의 시간복잡도가 낮은 덱 내장 메서드를 이용한다
    bfs_visited[V] = True  # 해당 V 값을 방문처리
    while q:  # q가 빌때까지 돈다.
        V = q.popleft()  # 큐에 있는 첫번째 값 꺼낸다.
        print(V, end=" ")  # 해당 값 출력
        for next_node in range(1, N + 1):  # 1부터 N까지 돈다
            if not bfs_visited[next_node] and graph[V][next_node]: 
                q.append(next_node) # next_node 추가
                bfs_visited[next_node] = True  # next_node 방문 처리


dfs(V)
print()
bfs(V)
