from collections import deque

def bfs(s, e):
    q = deque([])
    v = [0] * 100001
    shortcut = [0] * 100001

    q.append(s)
    v[s] = 1

    while q:
        c = q.popleft()
        if c == e: 
            return v[c]-1, shortcut
        
        for next in (c-1, c+1, c*2):
            if 0 <= next <= 100000:
                if v[next] == 0:
                    q.append(next)
                    v[next] = v[c] + 1
                    shortcut[next] = c # 방문 안했을때는 현재위치c가 제일 최신위치다

def recursive_path(s, e, shortcut):
    way = []
    c = e # 동생의 위치인 종착점(e)에서부터 출발
    while c != s: # 동생의 위치에서 수빈의 위치까지 즉 출발점(s)까지 역으로 추적
        way.append(c) # 현재 위치를 저장 --> 동생의 위치부터 수빈의 위치까지 역순으로 경로 저장
        c = shortcut[c] # 17 -> 16 -> 8 -> 4 순으로 저장된다

    way.append(s) # 이제 c == s일때 마지막으로 수빈의 시작점 5 추가

    return way[::-1]


N, K = map(int, input().split())
min_time, shortcut = bfs(N, K)
print(min_time)

final_shortcut = recursive_path(N, K, shortcut)
print(' '.join(map(str, final_shortcut)))