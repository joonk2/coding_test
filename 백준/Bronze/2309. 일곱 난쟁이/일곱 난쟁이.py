# https://www.youtube.com/watch?v=c38slnsLRk4
# 9난장이 키 합 132
# 7난장이 합 100
# 즉 2 난장이의 합이 32가 되는 것을 찾아서 빼자 

#✅n개 중에 2개 뽑는 알고리즘
#    for i in range(N-1):
#        for j in range(i+1, N)

def solve():
    N = 9
    target_num = sum(dwarf) - 100

    # N개 중에 2개 뽑는 모든 조합
    for i in range(N-1):
        for j in range(i+1, N): 
            if dwarf[i] + dwarf[j] == target_num:
                return dwarf[i], dwarf[j]

dwarf = [int(input()) for _ in range(9)]
n, m = solve() # 7명에 포함되지 않는 2명 찾기
for i in sorted(dwarf):
    if i != n and i != m:
        print(i)
