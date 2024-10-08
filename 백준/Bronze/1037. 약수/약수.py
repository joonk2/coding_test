import math
import sys

input = sys.stdin.readline
N = int(input())
arr = list(map(int, input().strip().split()))


if N == 1:
    print(arr[0]*arr[0])
else:
    print(min(arr)*max(arr))