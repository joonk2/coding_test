import sys
input = sys.stdin.readline
N,K = list(map(int, input().strip().split()))
data = []

for _ in range(N):
    school, id, solved, penalty = list(map(str, input().strip().split()))
    data.append((school, id, int(solved), int(penalty)))

data.sort(key = lambda x: (-x[2], x[3]))

ans = []
for i in range(N):
    if len(ans) == K:
        break
    if data[i][0] not in ans:
        ans.append(data[i][0])
        print(data[i][1])