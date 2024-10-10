# 1. 총총이가 이미 기록 전에도 춤추고 있었으니 lst or set에 먼저 추가해주자
# 2. 춤추는 토끼들 쌍을 찾아서 'ChongChong' 혹은 'other'이 있다면 
# 3. 동시에 추가해주면서 감염시켜나가는 방식으로 중복 안겹치게끔 추가하면 10인가?
# --> 그렇다면 lst가 아니라 set 이겠군

from collections import defaultdict
import sys
input = sys.stdin.readline

N = int(input())
dance = set()
dance.add('ChongChong')

for _ in range(N):
    x, y = list(map(str, input().strip().split()))

    if (x in dance) or (y in dance):
        dance.add(x)
        dance.add(y)

print(len(dance))