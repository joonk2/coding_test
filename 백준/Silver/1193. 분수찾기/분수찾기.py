# 1/1
# 1/2, 2/1
# 3/1, 2/2, 1/3
# 1/4, 2/3, 3/2, 4/1
# 5/1, 4/2, 3/3, 2/4, 1/5

# 줄위치 신경쓰자, N > line 루프가 풀리면 if ~ else는 while에 종속되지 않고 작동


N = int(input())

def converter(N):
    line = 1
    
    while N > line:
        N -= line
        line += 1

    if line % 2 == 0:
        top = N
        bottom = line - N + 1

    else:
        top = line - N + 1
        bottom = N

    return top, bottom


top, bottom = converter(N)
print(f"{top}/{bottom}")
