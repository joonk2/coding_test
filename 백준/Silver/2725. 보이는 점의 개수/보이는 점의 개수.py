# 점을 그려보면 x,y의 최대공약수가 1로 x와 y는 서로소 인것을 알 수 있다
# --> 즉 최대공약수가 1인 두점을 찾자
# 참! gcd(2,0) = 2    gcd(3,0) = 3 이다


# case 1) N크기에 따라 보이는 점들의 갯수를 찾자
# case 2) 서로소 인 것의 쌍을 찾자 



from math import gcd
dp = [0] * (1001)
dp[1] = 3

for i in range(2, 1001):
    # cnt_point 가 각 루프마다 초기화가 되야하기 때문에 이 위치에 반드시 배치할 것
    cnt_point = 0
    for j in range(1, i):
        # 서로소인 경우
        if gcd(i, j) == 1:
            cnt_point += 1
    
    dp[i] = dp[i-1] + (cnt_point*2)

C = int(input())
for _ in range(C):
    N = int(input())
    print(dp[N])  