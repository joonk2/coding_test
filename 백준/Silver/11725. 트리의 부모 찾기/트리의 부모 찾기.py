import sys
sys.setrecursionlimit(10**8)
input = sys.stdin.readline



def dfs(n):
    for i in graph[n]:
        if v[i] == 0:
            v[i] = n
            dfs(i)





N = int(input())
graph = [[] for _ in range(N+1)]
v = [0]*(N+1)

for _ in range(N-1):
    x,y = list(map(int, input().strip().split()))
    graph[x].append(y)
    graph[y].append(x)


dfs(1)


for i in range(2, N+1):
    print(v[i])