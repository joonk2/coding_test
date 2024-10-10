import math

V = input()




cnt_uc = 0
cnt_dp = 0

for s in V:
    if s == 'U' or s =='C':
        cnt_uc += 1
    elif s == 'D' or s =='P':
        cnt_dp += 1

result = ""
# 윤이가 선정될 수 있다면 U

if cnt_uc > math.ceil(cnt_dp/2):
    result += "U"
# 달구가 선정될 수 있다면 D
if cnt_dp > 0:
    result += "DP" 
# 포닉스가 선정될 수 있다면 P
if not result:
    result += "C"


print(result)