# 9부터 1까지 2칸씩 역방향으로 
# num[9:0:-2]

A,B = input().split()
A = int(A[::-1])
B = int(B[::-1])
print(max(A,B))