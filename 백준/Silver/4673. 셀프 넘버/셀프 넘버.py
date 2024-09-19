# for j in '23'이면 '2', '3'을 각 순회하여 최종적으로 i에 28을 저장

# 셀프넘버가 아닌 것은!!! 임의의 수 1개를 기준으로 연속 수열을 만드는 것을 의미
# 자릿수를 쪼개기 위해 문자열로 변환 후 각각 분리
# 결론은 셀프 넘버만 출력하기 위해 (기존 숫자리스트 - 연속 수열 리스트)
# 최종 정답은 셀프 넘버를 한줄에 하나씩 오름차순으로 출력

num_list = set(range(1, 10001))
generated_num = set()

for i in range(1, 10001):
    for j in str(i): # 360
        i += int(j) # 360 + 3 + 6 + 0
    generated_num.add(i)

self_number = sorted(num_list - generated_num)
for i in self_number:
    print(i)
