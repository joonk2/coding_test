def converter(card_status):
    cnt = card_status.count(0)
    if cnt == 0:
        return 'E'
    elif cnt == 1:
        return 'A'
    elif cnt == 2:
        return 'B'
    elif cnt == 3:
        return 'C'
    elif cnt == 4:
        return 'D'

# 3개의 테스트 케이스를 입력받고 각각 결과 출력
for _ in range(3):
    card_status = list(map(int, input().strip().split()))
    print(converter(card_status))