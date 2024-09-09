while True:
  num = sorted(list(map(int, input().split(' '))))
  if num[0] == num[1] == num[2] == 0:
    break
  elif num[0] + num[1] <= num[2]:
    print("Invalid")
  elif num[0] == num[1] == num[2]:
    print("Equilateral")
  elif num[0] == num[1] or num[1] == num[2]:
    print("Isosceles")
  elif num[0] != num[1] != num[2]:
    print("Scalene")