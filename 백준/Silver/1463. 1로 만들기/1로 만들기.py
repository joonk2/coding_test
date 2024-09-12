# 문제는 주어진 값으로 조건 3개를 이용해 최소 클릭 횟수로 1을 만드는 것이다
# 값이 2개가 주어졌으니 상향식으로 아래에서 위로 dp형식으로 만들자
# ex) dp[0] ~ dp[10]까지 필요할 때 (N+1)만큼 배열에 곱해야 dp[N]에 접근 가능

# N 10일때  클릭수의 최솟값을 계산하여 계산해보자 이는 아래와 같다
#  i  --> 0 1 2 3 4 5 6 7 8 9 10
# dp  --> 0 0 1 1 2 3 2 3 3 2 3

N = int(input())
dp = [0] * (N+1)

for i in range (2, N+1):
    dp[i] = dp[i-1]+1
    
    if i % 2 == 0: 
        dp[i] = min(dp[i], dp[i//2] + 1) 
    
    if i % 3 == 0 :
        dp[i] = min(dp[i], dp[i//3] + 1)

print(dp[N])
