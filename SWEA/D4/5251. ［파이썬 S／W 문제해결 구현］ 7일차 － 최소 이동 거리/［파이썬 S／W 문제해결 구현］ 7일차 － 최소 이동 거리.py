T = int(input())
for tc in range(1, T+1):
    N, E = map(int, input().split())


    # 인접행렬 초기화
    graph = [[0] *(N+1) for _ in range(N+1)]
    for _ in range(E):
        s, e, w = map(int, input().split())
        graph[s][e] = w

    # 거리와 방문 배열 초기화
    INF = float('inf')
    distance = [INF] * (N+1)
    visited = [0] * (N+1)
    distance[0] = 0

    for _ in range(N+1):
        # 아직 방문하지 않은 노드 중 최솟값 찾기
        min_idx = -1
        min_val = INF
        for i in range(N+1):
            if not visited[i] and distance[i] < min_val:
                min_val = distance[i]
                min_idx = i

        if min_idx == -1:
            break

        visited[min_idx] = 1

        # 인접 노드 거리 갱신
        for i in range(N+1):
            if not visited[i] and graph[min_idx][i] > 0:
                if distance[i] > distance[min_idx] + graph[min_idx][i]:
                    distance[i] = distance[min_idx] + graph[min_idx][i]

    print(f"#{tc} {distance[N]}")