N = list(map(int, input().split(' ')))
answer = sorted(N, reverse=True)
print(answer[1])