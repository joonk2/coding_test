# N회 만큼 명령을 수행한다
# 단순반복작업으로 인해 시간 초과가 난다면 sys를 input에 저장해주자
# 저장을 위해 빈 리스트의 stack이 필요하다
# word를 입력할 새로운 문자열 입력창도 만들자

import sys
input = sys.stdin.readline

N = int(input())
stack = []

for i in range(N):
    word = input().split()
    if word[0] == 'push':
        stack.append(word[1])
    elif word[0] == 'top':
        if not stack:  
            print(-1)
        else:
            print(stack[-1])
    elif word[0] == 'size':
        print(len(stack))
    elif word[0] == "empty":
        if not stack:  
            print(1)
        else:
            print(0)
    elif word[0] == 'pop':
        if not stack:  
            print(-1)
        else:
            print(stack.pop(-1))
