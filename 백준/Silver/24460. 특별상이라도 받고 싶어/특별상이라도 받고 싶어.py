import sys
# sys.setrecursionlimit(10**6)
N = int(sys.stdin.readline())
array = [list(map(int, sys.stdin.readline().strip().split())) for _ in range(N)]
def recursion(array, N):
    if len(array) == 1: # 특별상을 받을 수 있는 사람이 한 명이라면, 그 사람이 뽑힌다.
        return array[0][0]
    top_left = [i[:N//2] for i in array[:N//2]]
    top_right = [i[N//2:] for i in array[:N//2]]
    bottom_left = [i[:N//2] for i in array[N//2:]]
    bottom_right = [i[N//2:] for i in array[N//2:]]
    temp = [recursion(top_left, N // 2), recursion(top_right, N // 2),
            recursion(bottom_left, N // 2), recursion(bottom_right, N // 2)]
    temp.sort()
    return temp[1]
print(recursion(array, N))