import sys
input = sys.stdin.readline
N = int(input())
box = []

for i in range(N):
    box.append(int(input()))

ans = sorted(box, reverse=False)
for a in ans:
    print(a)