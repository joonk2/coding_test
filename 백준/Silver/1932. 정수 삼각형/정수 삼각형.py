# https://animoto1.tistory.com/entry/%EB%B0%B1%EC%A4%80-1932-%EC%A0%95%EC%88%98-%EC%82%BC%EA%B0%81%ED%98%95-%ED%8C%8C%EC%9D%B4%EC%8D%AC-Python

n = int(input())
dp = []

for i in range(n):
    dp.append(list(map(int, input().split())))

# print(dp)   테스트
# print(dp[1][0]) 테스트

for i in range(1, n): # 행
    for j in range(0, i+1): # 열
        if j == 0:
            dp[i][0] += dp[i-1][0]
        elif j == i:
            dp[i][j] += dp[i-1][j-1]
        else:
            dp[i][j] += max(dp[i-1][j-1], dp[i-1][j])

print(max(dp[n-1]))