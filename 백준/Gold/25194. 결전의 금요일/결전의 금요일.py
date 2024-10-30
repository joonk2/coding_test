from itertools import combinations as c
import sys
sys.setrecursionlimit(10**7)
input = sys.stdin.readline



def dfs(i, cum_sum):
    if cum_sum % 7 == 4:
        print("YES")
        exit()
    
    if i == N:
        return


    # 현재 요일 가산X
    dfs(i+1, cum_sum)
    
    # 현재 요일 가산O
    dfs(i+1, cum_sum + days[i]) 

N = int(input())
days = list(map(int, input().strip().split()))
days = [d for d in days if d % 7 != 0]
N = len(days)

dfs(0,0)
print("NO")