# X_n의 갯수 --> 2^(n-1)
# k번째니까 홀짝인가 -->
# 홀짝은 아니다 1번째일때 0, 2번째일때 1  3번째일때 1???
# 아 재귀를 통해 줄이면 되겠구나 그렇게해서 1번째면 0, 2번째면 1

# 테스트

# tc 1
 # 1. import math?
 # 2. math 아니다 가만보니 2^(n-1) 이라  (N//2) 로 줄이는게 낫겠다

# tc 2 
 # 3. 아 홀짝은 나눗셈했을때 나누기가 0 or 1이어야하니 
 # 아래 k --> k-1
 # 자연스럽게 함수값도 1-->0,   2--> 변경

# tc 3
 # k=7 일때 0이어야하는데 현재 코드로 계산해보니 1이다 
 # k=9 일때 1이어야하는데 현재 코드 계산하니 0
 # 아 return에 1-recursion 하면 되겠다

# tc 4
 # 로직 반대?


# import math
import sys
input = sys.stdin.readline



def recursion(N):
    if N == 0:
        return 0
    elif N == 1:
        return 1

    
    if N % 2 == 0:
        return recursion(N//2)
    else:
        return 1-recursion(N//2)


k = int(input())
print(recursion(k-1))