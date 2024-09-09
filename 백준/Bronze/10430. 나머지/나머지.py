A,B,C = list(map(int, input().split(' ')))

def calculator(x,y,z):
  return (x+y)%z, ((A%C)+(B%C))%C, (A*B)%C, ((A%C) * (B%C))%C

res = calculator(A,B,C)
for i in res:
  print(i)