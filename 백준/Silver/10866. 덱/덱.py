from collections import deque
import sys

input = sys.stdin.readline
N = int(input())
q = deque([])
for _ in range(N):
    word = input().strip().split()
        
    if word[0] == 'push_front':
        q.appendleft(word[1])
    elif word[0] == 'push_back':
        q.append(word[1])
    elif word[0] == 'pop_front':
        if not q:
            print(-1)
        else:
            print(q.popleft())
    elif word[0] == 'pop_back':
        if not q:
            print(-1)
        else:
            print(q.pop())
    elif word[0] == 'size':
        print(len(q))
    elif word[0] == 'empty':
        if not q:
            print(1)
        else:
            print(0)
    elif word[0] == 'front':
        if not q:
            print(-1)
        else:
            print(q[0])
    elif word[0] == 'back':
        if not q:
            print(-1)
        else:
            print(q[-1])