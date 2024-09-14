import sys
input = sys.stdin.readline
T = int(input())

for _ in range(T):
    scores = list(map(int, input().split()))
    avg = sum(scores[1:]) / scores[0]

    cnt = 0
    for i in scores[1:]:    
        if i > avg:
            cnt += 1
    percent =  (cnt / scores[0]) * 100
    print('%.3f' %percent + '%')