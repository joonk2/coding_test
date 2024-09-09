def solution(N):
  room = 1
  cnt = 1

  if N == 1:
    return '1'
  
  while N > room:
    room += (cnt*6)
    cnt += 1
  
  return cnt

N = int(input())
print(solution(N))
