# 총 테케 갯수 5
# 과목 수 + 점수를 리스트 입력으로 받는다
# 평균 낸 뒤에 평균 이상만 cnt하여 학생수 나눈다 --> 그걸로 % 구함

import sys
input = sys.stdin.readline

T = int(input())

for i in range(T):
    scores = list(map(int, input().split()))
    avg = sum(scores[1:]) / scores[0]
    cnt = 0

    for s in scores[1:]:
        if s >= avg:
            cnt += 1
    
    answer = (cnt / scores[0]) * 100
    print(f'{answer:.3f}%') 
