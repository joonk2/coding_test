# N회를 입력 후에 각 기능을 입력하여 결과를 출력한다
# input 보다 sys 처리속도가 더 빠르다
# 저장을 위해 빈 리스트의 stack이 필요하다
# word를 입력할 새로운 입력창도 만들자

import sys
input = sys.stdin.readline
N = int(input())
stack = []

for i in range(N):
    word = input().split()
    if word[0] == 'push':
        stack.append(word[1])
    elif word[0] == 'pop':
        if not stack:
            print(-1)
        else:
            print(stack.pop(-1))
    elif word[0] == 'size':
        print(len(stack))
    elif word[0] == 'empty':
        if not stack:
            print(1)
        else:
            print(0)
    elif word[0] == 'top':
        if not stack:
            print(-1)
        else:
            print(stack[-1])