# 누적합
# s=1, e=3 초기에는 1 대입, 맨 끝+1 에는 -1을 대입해서
# --> 이후의 리스트를 보자    즉 4시부터는 작업이 없게 된다
# [0, 1, 0, 0, -1]  ---> [0, 1, 1, 1, 0]


N = int(input())

time = [0]*1000002

for i in range(N):
    s, e = map(int, input().split())
    time[s] += 1
    time[e+1] += -1
    
for i in range(1, len(time)):
    time[i] += time[i-1]

count_hour = int(input())

hour_list = list(map(int, input().split()))

for i in range(count_hour):
    print(time[hour_list[i]])
