import sys
input = sys.stdin.readline
N, M = list(map(int, input().strip().split()))
arr = [int(input()) for _ in range(N)]
arr.sort()
s, e = 0, 1
min_val = float('inf')
while s < N and e < N:
    val = arr[e]-arr[s]
    if val >= M:
        min_val = min(min_val, val)
        s += 1
    else:
        e += 1
        
    if s == e:
        e += 1
print(min_val) 