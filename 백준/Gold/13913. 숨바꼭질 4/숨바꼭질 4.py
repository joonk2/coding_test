from collections import deque

def bfs(s, e):
    q = deque([])
    min_time = 0

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
                if v[next] ==  0:
                    q.append(next)
                    v[next] = v[c] + 1
                    shortcut[next] = c

def recursive_path(s, e, shortcut):
    way = []
    c = e
    while c != s:
        way.append(c)
        c = shortcut[c]
    way.append(s)

    return way[::-1]



N, K = map(int, input().split())

min_time, shortcut = bfs(N, K)
print(min_time)

final_shortcut = recursive_path(N, K, shortcut)
print(' '.join(map(str, final_shortcut)))