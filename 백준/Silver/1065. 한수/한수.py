# 한수
# 숫자 3자리 abc 라고 할때 a-b = b-c여야함
# 100미만 한수 갯수 1~99

# 210개의 한수
# 1~99 + 111, 123, 145, 147, 159, 210 총 105개

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