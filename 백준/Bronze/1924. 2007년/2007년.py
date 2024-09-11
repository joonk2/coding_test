a = ['SUN', 'MON', 'TUE', 'WED', 'THU', 'FRI', 'SAT'] 
b = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]

day = 0
m, d = list(map(int, input().split(' ')))

for i in range(m - 1):
    day += b[i] 

day += d
print(a[day % 7])