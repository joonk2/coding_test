# 문제가 연속정답이면 score += 1
# 입력받은 원소들 안에서 각각 쪼개서 연산하자

import sys
input = sys.stdin.readline
N = int(input())

for i in range(N):
    OX = input()
    score = 0
    sum = 0
    for j in OX:
        if j == 'O':
            score += 1
        else:
            score = 0
        sum += score
    
    print(sum)