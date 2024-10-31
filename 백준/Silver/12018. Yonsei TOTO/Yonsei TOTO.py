import sys
input = sys.stdin.readline

n, m = list(map(int, input().strip().split()))
li = []
for _ in range(n):
    P, L = list(map(int, input().strip().split()))
    point = list(map(int, input().strip().split()))
    point.sort(reverse=True)

    # 마지막에 문 닫고 들온 놈 뚧으려면 내가 걔보다 point 더 써야 한다
    if P >= L:
        li.append(point[L-1])
    else:
        li.append(1)


# 25, 20, 36, 14
li.sort()
cnt = 0
for i in li:
    if m-i >= 0:
        cnt += 1
        m -= i
print(cnt)