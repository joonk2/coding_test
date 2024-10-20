import sys
input = sys.stdin.readline
N = int(input())

# 중복 허용 --> 아 ENTER 뜨면 초기화해주고 세면 되구나

cnt = 0
gom = set()
for _ in range(N):
    name = input().strip()
    if name == 'ENTER':
        cnt += len(gom)
        gom.clear()
    else:
        gom.add(name)
        
        
cnt += len(gom)
print(cnt)