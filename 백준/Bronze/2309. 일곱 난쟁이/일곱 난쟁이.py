# 1. 입력은 9 난장이 키를 입력한다.
# 2. 찾는 난장이들 키의 합은 32로 2마리다
# (중복 선택이 없는 조합 알고리즘을 짜자)

# 3. 출력은 난장이 키의 합 100 기준으로 오름차순



# 2-1
def solve():
    N = 9
    target_num = sum(dwarf)-100
    
    # 2가지 조합(중복x)    N(N-1) / 2
    for i in range(N-1):
        for j in range(i+1, N):
            if dwarf[i] + dwarf[j] == target_num:
                return dwarf[i], dwarf[j]

# 1
dwarf = [int(input()) for _ in range(9)]

# 2-2 출력
n, m = solve()
for d in sorted(dwarf):
    if d != n and d != m:


        # 3
        print(d)
