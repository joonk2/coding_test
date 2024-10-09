# dp = [0]*(n+1) 사용시 메모리 초과더라
# 그래서 lst 형태로 값을 할당해주어 진행하면 통과


import sys
input = sys.stdin.readline
n = int(input())

fibo = [0, 1]

for i in range(2, n+1):
    fibo.append( (fibo[i-2]+fibo[i-1]) % 1000000007 )

print(fibo[n])