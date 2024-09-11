# 일 월 화 수 목 금 토 
# 1,2,3,4,5,6, 7 번째
# 요일 반복 --> 일~토 [0 ~ 6] 반복
# 9월 2일을 구하고 싶다 --> 8월까지의 일자를 전부 합산 후 2일을 더한다(자료구조 형식 조심)


a = ['SUN', 'MON', 'TUE', 'WED', 'THU', 'FRI', 'SAT'] 
b = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]

day = 0
m, d = list(map(int, input().split(' ')))

for i in range(m - 1):
    day += b[i] 

day += d
print(a[day % 7])
