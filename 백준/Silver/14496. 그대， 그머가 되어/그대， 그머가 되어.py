from collections import deque
import sys
input = sys.stdin.readline

def bfs(s, e):
    q = deque([])
    q.append(s)
    v[s] = 0
    
    while q:
        c = q.popleft()
        if c == e:
            return v[c]
        
        for n in adj[c]:
            if v[n] == -2:
                q.append(n)
                v[n] = v[c]+1
    return -1




a,b = list(map(int, input().strip().split()))
N,M = list(map(int, input().strip().split()))
adj = [[] for _ in range(N+1)]
v = [-2]*(N+1)

for _ in range(M):
    x,y = list(map(int, input().strip().split()))
    if x == y:
        continue
    adj[x].append(y)
    adj[y].append(x)

print(bfs(a,b))