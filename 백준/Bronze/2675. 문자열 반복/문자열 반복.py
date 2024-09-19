import sys
input = sys.stdin.readline
T = int(input())

for i in range(T):
    answer = ''
    cnt, word = input().split()
    for j in word:
        answer += int(cnt) * j
    print(answer)