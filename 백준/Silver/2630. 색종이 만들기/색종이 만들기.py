import sys
input = sys.stdin.readline

def solution(arr, x, y, N):
    global blue, white
    color = arr[x][y]
    
    for i in range(x, x + N):
        for j in range(y, y + N):
            if arr[i][j] != color:  # 다른 색을 발견하면
                # 4등분하여 재귀 호출
                solution(arr, x, y, N // 2)          # 왼쪽 위
                solution(arr, x, y + N // 2, N // 2)  # 오른쪽 위
                solution(arr, x + N // 2, y, N // 2)  # 왼쪽 아래
                solution(arr, x + N // 2, y + N // 2, N // 2)  # 오른쪽 아래
                return  # 모두 같은 색이 아니므로 함수 종료

    # 모두 같은 색일 경우
    if color == 0:
        white += 1  # 하얀색 개수 증가
    else:
        blue += 1   # 파란색 개수 증가

N = int(input())
arr = [list(map(int, input().strip().split())) for _ in range(N)]
blue = 0
white = 0

solution(arr, 0, 0, N)  # 시작 위치 (0, 0)에서 시작
print(white)  # 하얀색 색종이 개수
print(blue)   # 파란색 색종이 개수