from collections import deque
import sys 

queue = deque([])
input = sys.stdin.readline
N = int(input())

for i in range(N):
    word = input().split()
    if word[0] =='push':
        queue.append(word[1])
    elif word[0] == 'pop':
        if not queue:
            print(-1)
        else:
            print(queue.popleft())
    elif word[0] == 'size':
        print(len(queue))
    elif word[0] == 'empty':
        if not queue:
            print(1)
        else:
            print(0)
    elif word[0] == 'front':
        if not queue:
            print(-1)
        else:
            print(queue[0])
    elif word[0] == 'back':
        if not queue:
            print(-1)
        else:
            print(queue[-1])