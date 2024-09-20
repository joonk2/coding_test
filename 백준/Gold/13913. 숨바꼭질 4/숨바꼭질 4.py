from collections import deque

def bfs(s, e):
    q = deque([])
    v = [0] * 100001
    shortcut = [0] * 100001

    q.append(s)
    v[s] = 1

    min_time = 0

    while q:
        c = q.popleft()
        if c == e:
            min_time = v[c]-1
            return min_time, shortcut
        
        for next in (c-1, c+1, c*2):
            if 0 <= next <= 100000:
                if v[next] == 0:
                    q.append(next)
                    v[next] = v[c]+1
                    shortcut[next] = c # 경로 역추적을 위한 빌드업(직전 위치 최신화)
                    
    return '다시 해라 임마' # 디버깅



def upsidedown_path(s, e, shortcut):
    way = []
    c = e # 동생의 위치인 종착점(e)에서부터 출발
    while c != s: # 동생의 위치에서 수빈의 위치까지 즉 출발점(s)까지 역으로 추적
        way.append(c) # 현재 위치를 저장 --> 동생의 위치부터 수빈의 위치까지 역순으로 경로 저장
        c = shortcut[c] # 17 -> 16 -> 8 -> 4
    
    way.append(s) # 이제 c == s일때 마지막으로 수빈의 시작점 5 추가

    return way[::-1]

N, K = map(int, input().split())
min_time, shortcut= bfs(N, K)
print(min_time)

final_shortcut = upsidedown_path(N, K, shortcut)
print(' '.join(map(str, final_shortcut)))
