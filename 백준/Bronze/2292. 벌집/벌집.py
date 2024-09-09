N = int(input())

def solution(N):
  if N==1:
    return 1

  room=1
  layer=1

  while room < N:
    room += (6*layer)
    layer += 1
  
  return layer

print(solution(N))