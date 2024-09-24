import sys
input = sys.stdin.readline

T = int(input())

for i in range(T):
    x = list(map(int, input().split()))
    print(x[0]+x[1])