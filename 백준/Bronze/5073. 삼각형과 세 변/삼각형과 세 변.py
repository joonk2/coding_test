while True:
    num = sorted(list(map(int, input().split())))

    # 0 0 0 입력이 들어오면 반복 종료
    if num[0] == num[1] == num[2] == 0:
        break

    # 삼각형이 유효하지 않은 경우 (두 짧은 변의 합이 가장 긴 변보다 작거나 같으면 삼각형이 될 수 없음)
    if num[0] + num[1] <= num[2]:
        print("Invalid")
    # 세 변의 길이가 모두 같은 경우
    elif num[0] == num[1] == num[2]:
        print("Equilateral")
    # 두 변의 길이가 같은 경우
    elif num[0] == num[1] or num[1] == num[2] or num[2]==num[0]:
        print("Isosceles")
    # 세 변의 길이가 모두 다른 경우
    else:
        print("Scalene")