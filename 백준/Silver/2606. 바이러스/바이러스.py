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
import sys
input = sys.stdin.readline

N = int(input())
M = int(input())



# 컴퓨터 세팅 --> 인덱스 0~7, 근데 실제로는 1~7만 필요
adj = [ [] for _ in range(N+1)]

# adjacency list connecting
for _ in range(M):
    s, e = map(int, input().split())
    adj[s].append(e)
    adj[e].append(s)

ans = 0
v = [0] * (N+1)
dfs(1)
print(ans-1)