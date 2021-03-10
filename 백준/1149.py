import sys
#https://chunghyup.tistory.com/48
n = int(sys.stdin.readline())
houses = []
#각 rgb 별 비용 입력
for i in range(n):
    houses.append(list(map(int, sys.stdin.readline().split())))

for i in range(1, n):
    houses[i][0] = min(houses[i - 1][1], houses[i - 1][2]) + houses[i][0]
    houses[i][1] = min(houses[i - 1][0], houses[i - 1][2]) + houses[i][1]
    houses[i][2] = min(houses[i - 1][0], houses[i - 1][1]) + houses[i][2]

print(min(houses[n-1][0],houses[n-1][1],houses[n-1][2]))
