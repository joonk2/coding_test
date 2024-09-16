# 한수
# 숫자 3자리 abc라고 할 때 a-b = b-c 여야함
# 100미만 한수 -> 1~99

# 210개의 한수
# 1~99 + 111, 123, 135, 147, 159, 210 --> 총 105개 

# 매우 중요 ! --> 정수는 인덱스로 접근할 수 없다  (문자열 변환이 필요하겠네?)

import sys
input = sys.stdin.readline
N = int(input())
cnt = 0

for i in range(1, N+1):
    if 1 <= i < 100:
        cnt += 1
    elif 100 <= i < 1000:
        sep = list(map(int, str(i)))
        if sep[0]-sep[1] == sep[1]-sep[2]:
            cnt += 1
print(cnt)
