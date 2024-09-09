import math
# H행 W열에서 모든 자리에 책상을 비치하며 간격은 1칸씩 띄워서 사람들이 착석 가능

def solution(H,W,N,M):
  x = math.ceil(H/(N+1))
  y = math.ceil(W/(M+1))
  return x*y

H,W,N,M = list(map(int, input().split()))
print(solution(H,W,N,M))
