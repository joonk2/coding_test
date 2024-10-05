# 최솟값의 합 but 각 자리별 누적 합 --> 정렬(asc)
# 1 2 3 3 4 --> 1 + 3 + 6 + 9 + 13 --> 32
# dp는 출력초과

import sys
input = sys.stdin.readline
N = int(input())
Pi = [0] + list(map(int, input().strip().split()))

min_sum = 0
Pi.sort()
# 각 자리별 누적합 알고리즘
for i in range(1, N+1):
    for j in range(i+1):
        min_sum += Pi[j]

print(min_sum)