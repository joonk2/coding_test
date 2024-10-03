# 누적합

# 입출력 1
# s=1, e=3 초기에는 1 대입, 맨 끝+1 에는 -1을 대입해서
# --> 이후의 리스트를 보자    즉 4시부터는 작업이 없게 된다
# [0, 1, 0, 0, -1]  ---> [0, 1, 1, 1, 0]

# 입출력 2
# s=1 e=5    s=3 e=6
# [0,1,0,1,0,0,-1,-1] --> [0,1,1,2,2,2,1,0]
# 3,4,5시는 시간 2번 겹치고 6시부터는 1번 그리고 7시부터 예약 가능

N = int(input())
time = [0] * 1000002

# 1. 누적합
for i in range(N):
    s, e = list(map(int, input().split()))
    time[s] += 1
    time[e+1] += -1

for j in range(1, len(time)):
    time[j] += time[j-1]

# 2. cnt
cnt_hour = int(input())
hour_list = list(map(int, input().split()))

for k in range(cnt_hour):
    print(time[hour_list[k]])
