# cum sum
import sys
input = sys.stdin.readline
N, K = map(int, input().split())
dolls = list(map(int, input().split()))
ans = 10**8

lion = []
for i in range(len(dolls)):
    if dolls[i] == 1:
        lion.append(i)

s, e = 0, K-1
if len(lion) < K:
    print(-1)
    exit(0)

while True:
    d = lion[e] - lion[s]+1
    ans = min(ans, d)
    if e == len(lion)-1:
        break
    s += 1
    e += 1
print(ans)