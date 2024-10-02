# case 1. 특별상을 받을 수 있는 사람이 한 명이라면, 그 사람이 뽑힌다

# case 2. 안그렇다면, 정사각형 4개로 나눠 각 구역에서 재귀함수를 적용해 한명씩 총 4번 선택
    # 2-1. 가로 2등분
    # 2-2. 거기서 세로로 반 가른다
    # 2-3. 함수가 끝나기 전에 빈 리스트 할당 후에 재귀함수 적용해서 똑같이
    # 2-4. 정렬 후 인덱스 1번값 반환
    # 2-5. 재귀함수 호출 마치고 최종적으로 본 함수에서 마지막으로 return index(1)


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
