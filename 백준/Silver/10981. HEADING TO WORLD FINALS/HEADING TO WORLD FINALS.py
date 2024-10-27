import sys
input = sys.stdin.readline
N,K = map(int, input().strip().split())
data = []
for _ in range(N):
    univ, team, solved, penalty = list(map(str, input().split()))
    data.append((univ, team, int(solved), int(penalty)))


data.sort(key = lambda x: (-x[2], x[3]))
ans = []
for i in range(N):
    if len(ans) == K:
        break
    if data[i][0] not in ans:
        print(data[i][1])
        ans.append(data[i][0])