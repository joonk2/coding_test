# case 1) 특별상을 받을 수 있는 사람이 1명이라면?

# case 2) 그렇지 않은 경우 --> 대회장을 같은 크기의 정사가형 4개로 나눠 재귀적으로 나눠 총 4명 선택
    # 2-1) 가로로 2등분
    # 2-2) 세로로 2등분
    # 2-3) 다시 재귀
    # 2-4 리스트에 각 4등분의 위치에 해당하는 인덱스 1번 요소들 할당
    # 2-5 최종 리스트이 인덱스 1번 반환  


import sys
# sys.setrecursionlimit(10**6)
N = int(sys.stdin.readline())
arr = [list(map(int, sys.stdin.readline().strip().split())) for _ in range(N)]

def recursion(arr, N):
    if len(arr) == 1: # 후보자가 한명 밖에 없으면 그냥 맨 첫 번째 사람 뽑는다
        return arr[0][0]

    # 그게 아니라면 가로로 2등분 하고 거기서 또 세로로 반 나눠서 4등분하여 재귀
    top_left = [i[:N//2] for i in arr[:N//2]]
    top_right = [i[N//2:] for i in arr[:N//2]]
    bottom_left = [i[:N//2] for i in arr[N//2:]]
    bottom_right = [i[N//2:] for i in arr[N//2:]]
    temp = [recursion(top_left, N//2), recursion(top_right, N//2),
            recursion(bottom_left, N//2), recursion(bottom_right, N//2)]
    temp.sort()

    # top_left, top_right, bottom_left, bottom_right의 각 인덱스 1번 temp에 할당 --> 최종 temp의 index(1) 반환
    return temp[1]

print(recursion(arr, N))
