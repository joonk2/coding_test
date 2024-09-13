n = int(input())
score = list(map(int, input().split()))

m = max(score)
sum_value = 0
for i in range(n):
  sum_value += (score[i]/m*100)

print(sum_value/n)