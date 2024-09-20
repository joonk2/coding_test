# 1.  방문 처리에서 +1 했으므로 min_time에서 다시 1 빼줌
# 2. 방향조건에서 next가 0 <=   <= 100000 일때
# 3. case 1) 방문 안했으면 --> q에 추가, 다음좌표 처리 v[next] = v[c]+1
# 4. case 2) 재방문 --> q에만 추가
# 5. 현재좌표와 끝 좌표가 같을 때 시간 = 현재좌표-1, 최단거리 가산, 그리고 계속


from collections import deque

def bfs(s, e):
    q = deque([])
    v = [0] * 100001
    q.append(s)
    v[s] = 1

    min_time = 0
    cnt_shortcut = 0

    while q:
        c = q.popleft()
        if c == e:
            min_time = v[c]-1
            cnt_shortcut += 1
            continue

        for next in (c-1, c+1, c*2):
            if 0 <= next <= 100000:
                if v[next] == 0:
                    q.append(next)
                    v[next] = v[c]+1
                elif v[next] == v[c] + 1:
                    q.append(next)

    return min_time, cnt_shortcut

    


N, K = map(int, input().split())
min_time, cnt_shortcut = bfs(N, K)
print(min_time)
print(cnt_shortcut)