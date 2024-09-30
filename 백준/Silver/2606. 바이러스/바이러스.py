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

# 늘 그렇지만 우린 인덱스 1번부터 쓴다 0은 버린다
adj = [ [] for _ in range(N+1) ]
for _ in range(M):
    s, e = map(int, input().split())
    adj[s].append(e)
    adj[e].append(s)


ans = 0
v = [0]* (N+1)
dfs(1)
print(ans - 1)