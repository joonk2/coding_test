import sys
input = sys.stdin.readline

def recursion(arr, N):
    # case 1) -> 마지막에 남은 수 출력
    if len(arr) == 1:
        return arr[0][0]

    # case 2) 재귀 분해
    top_left = [i[:(N//2)] for i in arr[:(N//2)]]  
    top_right = [i[(N//2):] for i in arr[:(N//2)]]  
    bottom_left = [i[:(N//2)] for i in arr[(N//2):]]  
    bottom_right = [i[(N//2):] for i in arr[(N//2):]]  

 
    temp = [recursion(top_left, N//2), recursion(top_right, N//2),
            recursion(bottom_left, N//2), recursion(bottom_right, N//2)]
    
    temp.sort()
    return temp[-2]  

N = int(input())
arr = [list(map(int, input().strip().split())) for _ in range(N)]
ans = recursion(arr, N)
print(ans)