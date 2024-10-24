# 주기 +-1 초씩 증감할 수 있다는 것은 속임수다,  <= 2 가 맞다


import sys
input = sys.stdin.readline
N, T = list(map(int, input().strip().split()))
periods = list(map(int, input().strip().split()))
cnt = 0
for p in periods:
    for i in range(1000):
        if T % (p+i) == 0 or T % (p-i) == 0:
            cnt += i
            break
print(cnt)