# 갯수 셀때는 dfs가 답이여


# 2. dfs

def dfs(c):
    global ans
    ans += 1
    
    v[c] = 1

    for n in adj[c]: 
        if not v[n]:
            dfs(n)



# 1. 입출력 세팅
N = int(input())
M = int(input())

adj = [ [] for _ in range(N+1)]
for _ in range(M):
    s, e = map(int, input().split())
    adj[s].append(e)
    adj[e].append(s)

ans = 0
v = [0]*(N+1)
dfs(1)
print(ans-1)