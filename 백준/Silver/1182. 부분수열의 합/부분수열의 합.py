# 조합?   탐욕법?

# 1. 조합
    # 5C3 일때 sum(arr) == 0 인것 고르는 것인가

import sys
from itertools import combinations as c
N, S = list(map(int, input().strip().split()))
arr = list(map(int, input().strip().split()))

cnt = 0
for i in range(1, N+1):
    comb = c(arr, i)

    for x in comb:
        if sum(x) == S:
            cnt += 1
print(cnt)