import sys
input = sys.stdin.readline
N,L = list(map(int, input().strip().split()))
arr = list(map(int, input().strip().split()))
arr.sort()

cnt = 0
tape = 0
for i in arr:
    if tape < i:
        tape = i+L-1
        cnt += 1
print(cnt)