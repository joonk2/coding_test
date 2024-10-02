# case 1. 특별상을 받을 수 있는 사람이 1명이면 그 사람만 뽑는다

# case 2. 안그렇다면 정사각형으로 4등분해서 재귀함수를 적용해 각 구역마다 1명씩 총 4명 뽑는다
#     2-1. 가로로 2등분
#     2-2. 세로로 반 가른다
#     2-3. 빈 리스트를 만들어 함수가 끝나기 전에 재귀함수로 호출해준다
#     2-4. 정렬 후에 인덱스 1번값 반환 --> 리스트에 4명
#     2-5. 이제 본 함수에서 최종적으로 return lst[1] 하면 1명만 나온다 

import sys
input = sys.stdin.readline
N = int(input())
arr = [list(map(int, input().strip().split())) for _ in range(N)]

def recursion(arr, N):
    # case 1) 특별상을 받을 수 있는 사람이 한 명이라면, 그 사람이 뽑힌다.
    if len(arr) == 1:
        return arr[0][0]
    
    # case 2) 안그렇다면 정사각형으로 4등분해서 재귀함수를 적용해 각 구역마다 1명씩 총 4명 뽑는다
    top_left = [i[:(N//2)] for i in arr[:(N//2)]]
    top_right = [i[(N//2):] for i in arr[:(N//2)]]
    bottom_left = [i[:(N//2)] for i in arr[(N//2):]]
    bottom_right = [i[(N//2):] for i in arr[(N//2):]]

    temp = [recursion(top_left, N//2), recursion(top_right, N//2),
            recursion(bottom_left, N//2), recursion(bottom_right, N//2)]
    
    temp.sort()
    return temp[1]



print(recursion(arr, N))
