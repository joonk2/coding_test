# 누적합

# 입출력 1
# s=1, e=3 초기에는 1 대입, 맨 끝+1 에는 -1을 대입해서
# --> 이후의 리스트를 보자    즉 4시부터는 작업이 없게 된다
# [0, 1, 0, 0, -1]  ---> [0, 1, 1, 1, 0]

# 입출력 2
# s=1 e=5    s=3 e=6
# [0,1,0,1,0,0,-1,-1] --> [0,1,1,2,2,2,1,0]
# 3,4,5는 시간 2번 겹치고 6시부터는 1번 그리고 7시부터 예약 가능


# 누적합과 cnt로 보자

# 입출력 1
# s=1, e=3 초기에는 1대입 맨 끝+1에는 -1 대입해서
# --> 이후의 리스트를 보자 즉 4시부터는 작업이 없다
# [0,1,0,0,-1] --> [0,1,1,1,0]

# 입출력 2
# s=1, e=5,     s=3, e=6
# [0,1,0,1,0,0,-1,-1] --> [0,1,1,2,2,2,1,0]
# 3,4,5시는 시간 2번씩 겹치고 6시부터 1번 그리고 7시부터 예약가능

import sys
input = sys.stdin.readline
N = int(input())

time = [0] * 1000002

# 1. 누적합 세팅
for i in range(N):
    s, e = list(map(int, input().strip().split()))
    time[s] += 1
    time[e+1] += -1

# 2. 누적합 적용
for j in range(1, len(time)):
    time[j] += time[j-1]

# 3. 횟수 계산
Q = int(input())
hour_list = list(map(int, input().strip().split()))

for k in range(Q):
    print(time[hour_list[k]])
