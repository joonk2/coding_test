import math
import sys
input = sys.stdin.readline
N = int(input())
String = input()

cnt = 0
for s in String:
    if s == 'C':
        cnt += 1

# print(cnt)
ans = math.ceil(cnt / (N-cnt+1))
print(ans)