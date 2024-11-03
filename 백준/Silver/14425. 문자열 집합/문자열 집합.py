import sys
input = sys.stdin.readline
N,M = list(map(int, input().rstrip().split()))
set_ = set()
cnt = 0

for _ in range(N):
    word = input().rstrip()
    set_.add(word)

for _ in range(M):
    word = input().rstrip()
    if word in set_:
        cnt += 1

print(cnt)