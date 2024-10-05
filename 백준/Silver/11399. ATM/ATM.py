import sys
input = sys.stdin.readline
N = int(input())
arr = [0] + list(map(int, input().strip().split()))
arr.sort()

sum = 0
for i in range(1, N+1):
    for j in range(i+1):
        sum += arr[j]
print(sum)