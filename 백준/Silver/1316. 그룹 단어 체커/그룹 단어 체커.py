# case 1) 1자리라면 무조건 그룹단어

# case 2-1) 2자리 이상일 때 전 인덱스의 문자와 그 뒤 인덱스 문자 같을 때 --> pass
# case 2-2) 2자리 이상일 때 전 인덱스의 문자가 뒤의 범위에서 나올 때 --> break

# case 3) 위의 조건 확인 후 i가 마지막 index면 cnt += 1

import sys
input = sys.stdin.readline
N = int(input())
cnt = 0

for _ in range(N):
    word = input()
    
    if len(word) == 1: # word 가 만약에 한자리면은 무조건 그룹단어
        cnt += 1 #따라서 +1
    else: #2자리 이상이라면
        for i in range(1, len(word)): #2번째 인덱스부터 마지막 인덱스까지
            if word[i-1] == word[i]: #문자 두개씩 비교를 해서 만약 같다면
                pass # 아무것도 하지 않는다
            
            # 만약 문자 두개가 다르고
            # 앞의 문자가 뒤 문자부터 마지막 인덱스 안에 또 등장한다면
            elif word[i-1] in word[i:]:  
                break # 다음 반복문으로 넘어간다

            #만약 위의 반복문 break없이 다돌고 마지막 인덱스까지 왔다면
            if i == len(word)-1:
                cnt += 1

print(cnt)
