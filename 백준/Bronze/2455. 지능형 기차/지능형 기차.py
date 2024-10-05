import sys
input = sys.stdin.readline

current_passengers = 0  # 현재 기차의 승객 수
max_passengers = 0  # 최대 승객 수

for _ in range(4):
    exit_passengers, enter_passengers = map(int, input().split())
    current_passengers += enter_passengers - exit_passengers  # 승객 수 업데이트
    max_passengers = max(max_passengers, current_passengers)  # 최대 승객 수 업데이트

print(max_passengers)