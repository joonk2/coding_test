# 계단 밟기 최댓값 
# 첫 계단은 무조건 새로 올라간 지점부터 시작하니 거기가 1층
# 연속으로 계단밟기는 1칸 or 2칸만
# 4번째 계단 밟기 --> 124 134 24
# 계단 첫 시작이 아닌 맨 끝에서부터 n, n-1, n-2 ~ n-5 까지 아래로 계산하여
# 꼭대기 까지 한계단? 두계단을 어떻게 올라왔을지 거꾸로 생각해보자
# https://daimhada.tistory.com/181

import sys
input = sys.stdin.readline
N = int(input())


stairs = [0] * 301
for i in range(1, N+1):
    stairs[i] = int(input())

dp = [0] * 301

dp[1] = stairs[1]
dp[2] = stairs[1] + stairs[2]

dp[3] = max(stairs[2]+stairs[3], stairs[1]+stairs[3])
# 2번쨰 계단에서 3번쨰 계단으로 올라가기 vs 1번째 계단에서 3번째 계단으로 밟는 경우

for j in range(4, N+1):
    dp[j] = max(dp[j-3] + stairs[j] + stairs[j-1], dp[j-2] + stairs[j])
    
print(dp[N])
