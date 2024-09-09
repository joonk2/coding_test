A, B = list(map(int, input().split(' ')))

def calculator(x, y):
  return (x+y, x-y, x*y, int(x/y), x%y)



res = calculator(A, B)
for i in res:
  print(i)