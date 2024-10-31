import sys
input = sys.stdin.readline

def dfs(s, cnt):
    global v
    v[s] = 1
    
    for n in adj[s]:
        if v[n] == 0:
            cnt = dfs(n, cnt+1)
    return cnt


N = int(input())
adj = [[] for _ in range(N+1)]


# 친구관계
for x in range(1, N+1):
    y = int(input().strip())
    adj[x].append(y)


# dfs 수행
ans = [0]*(N+1)
for i in range(1, N+1):
    v = [0]*(N+1)
    ans[i] = dfs(i, 1)

print(ans.index(max(ans)))