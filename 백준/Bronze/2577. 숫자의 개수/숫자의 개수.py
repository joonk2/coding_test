# A*B*C를 한 값에서 0부터 9까지 각각의 숫자가 몇번 쓰였는지 계산한다

a = int(input())
b = int(input())
c = int(input())

100 <= a < 1000 and 100 <= b< 1000 and 100 <= c < 1000

result = str(a*b*c)

for i in range(0,10):
    print(result.count(str(i)))