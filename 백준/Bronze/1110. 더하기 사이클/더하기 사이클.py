N = int(input())
cnt = 0
start = N
while True:
  a = start // 10
  b = start % 10
  c = a+b

  start = (b*10) + (c%10)
  cnt += 1

  if N == start:
    break

print(cnt)