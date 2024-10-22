# 고르는 방법의 수 ?  4Cx      5Cx

from itertools import combinations as c
import sys
input = sys.stdin.readline
N,L,R,X = list(map(int, input().strip().split()))
level = list(map(int, input().strip().split()))

cnt = 0
for i in range(1, N+1):
    comb = c(level, i)

    for x in comb:
        if L <= sum(x) <= R and  X <= max(x)-min(x):
            cnt += 1

print(cnt)