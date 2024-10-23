S = input()
word_list = []
for _ in range(int(input())):
    word_list.append(input())
# 모든 알파벳을 다른 알파벳으로 변환하는 딕셔너리 만들기
alphabet = 'abcdefghijklmnopqrstuvwxyz'
for i in range(26):
    dic = {}
    for j in range(26):
        dic[alphabet[j]] = alphabet[(i + j) % 26]
    # 만든 딕셔너리에 맞춰서 주어진 문자열 변환
    transform = ''
    for s in S:
        transform += dic[s]
    # 만약 그 문자열에 사전에 있는 단어가 존재하면 출력
    for w in word_list:
        if w in transform:
            print(transform)
            exit()