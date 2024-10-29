import sys
input = sys.stdin.readline
N = int(input())
arr = list(map(int, input().split()))
ans = 0

# 자신까지의 누적합 배열
cum_sum = [arr[0]]
for i in range(1, N):
    cum_sum.append(cum_sum[i-1]+arr[i])

# a*b+a*c=a*(b+c)를 이용
for j in range(N):
    ans += (arr[j] * (cum_sum[N-1]-cum_sum[j]))

print(ans)