import sys
import math
from itertools import combinations as c
input = sys.stdin.readline


def back(size, i, time):
    global max_size
    size += seq[i]
    if time == M:
        max_size = max(max_size, size)
        return
    if i == N-1:
        max_size = max(max_size, size)
        return
    if i+1 < N:
        back(size, i+1, time+1)
    if i+2 < N:
        back(math.trunc(size/2), i+2, time+1)

N,M = list(map(int, input().strip().split()))
seq = list(map(int, input().strip().split()))
max_size = 0
back(1,0,1)

if N > 1:
    back(0,1,1)
print(max_size)