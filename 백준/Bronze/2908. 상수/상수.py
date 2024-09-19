# 9부터 3까지 2만큼 역방향으로
# num[9:3:-2]

A,B = input().split()

A = int(A[::-1])
B = int(B[::-1])
print(max(A,B))