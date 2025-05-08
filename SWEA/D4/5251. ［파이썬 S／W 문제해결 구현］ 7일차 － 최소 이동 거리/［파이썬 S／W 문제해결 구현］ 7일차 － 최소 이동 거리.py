import heapq

T = int(input())
for tc in range(1, T+1):
    N, E = map(int, input().split())

    adj_lst = [[] for _ in range(N+1)]
    for _ in range(E):
        s,e,w = map(int, input().split())
        adj_lst[s].append((e,w))


    # 최단경로 리스트
    INF = float('inf')
    min_dist = [INF] *(N+1)
    min_dist[0] = 0

    # 우선순위 큐 (현재 노드, 가중치)
    pq = [(0,0)]
    while pq:
        cur_node, cur_w = heapq.heappop(pq)
        # 인접 리스트를 탐색
        for adj_node, adj_w in adj_lst[cur_node]:
            next_w = cur_w + adj_w
            if min_dist[adj_node] > next_w:
                min_dist[adj_node] = next_w

                # 최소값 갱신
                heapq.heappush(pq, (adj_node, next_w))

    print(f"#{tc} {min_dist[N]}")