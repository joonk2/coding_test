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
