# co = [[1, 2, 3], [1, 5]]  일때  set(sum(co, [])) --> [1,2,3,5]

from itertools import combinations as c
import sys
input = sys.stdin.readline
N, M = list(map(int, input().strip().split()))
li = []

for _ in range(M):
    li.append(list(map(int, input().strip().split()))[1:])

def combi():
    for i in range(1, min(11, N+1)):
        comb = list(c(li, i))
        for co in comb:
            if len(set(range(1, N+1)) - set(sum(co, []))) == 0:
                return i
    return -1 

print(combi())