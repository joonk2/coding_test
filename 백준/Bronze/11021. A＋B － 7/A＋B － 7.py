import sys
input = sys.stdin.readline
T = int(input())
for i in range(T):
    A,B = list(map(int, input().strip().split()))
    print(f"Case #{i+1}: {A+B}")