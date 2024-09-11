m,d = list(map(int, input().split(' ')))
x = ['SUN', 'MON', 'TUE', 'WED', 'THU', 'FRI', 'SAT']
y = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]

day = 0
for i in range(m-1):
  day += y[i]

day += d
print(x[day%7])