import math

V = input()

# U와 C, D와 P를 카운트하는 변수
count_uc, count_dp = 0, 0

for s in V:
    if s == 'U' or s == 'C':
        count_uc += 1
    elif s == 'D' or s == 'P':
        count_dp += 1

result = ""

# case 1) 윤이 (U)가 선정될 수 있는지 확인
if count_uc > math.ceil(count_dp / 2):
    result += "U"

# case 2) 달구 (D), 포닉스 (P)가 선정될 수 있는지 확인
if count_dp > 0:
    result += "DP"

# case 3) 결과가 없다면 C를 출력
if not result:
    result = "C"

# 결과 출력
print(result)