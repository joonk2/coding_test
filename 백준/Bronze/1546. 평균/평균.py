N = int(input())
score = list(map(int, input().split(' ')))
max_score = max(score)
sum = 0
for i in range(N):
  sum += ((score[i]/max_score) * 100)

print(sum/N)
