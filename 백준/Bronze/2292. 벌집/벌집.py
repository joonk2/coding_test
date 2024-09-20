# 5층 + 0.3
# 1
# 6
# 12
# 18
# 24
# +9


import sys
input = sys.stdin.readline
N = int(input())

def solution(N):
    room = 1
    cnt = 1

    if N == 1:
        return '1'
    
    while N > room:
        room += (cnt * 6)
        cnt += 1

    return cnt

print(solution(N))


# N = int(input())
# room = 1
# cnt = 1

# if N == 1:
#     print(1)

# while N > room:
#     room += (cnt * 6)
#     cnt += 1

# print(cnt)
