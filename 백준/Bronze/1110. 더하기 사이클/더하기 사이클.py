# start = N
# a = 몫
# b = 나머지, 근데 10의 자리면 %10 하여 나머지만 가져오자
# c = (a+b)%10
# start = (b*10) + c

N = int(input())
cnt = 0
start = N
while True:
  a = start // 10
  b = start % 10
  c = (a+b)%10

  start = (b*10)+c
  cnt += 1

  if start == N:
    break

print(cnt)
