def solution(N, number):
    answer = -1
    dp = []

    for i in range(1, 9):  # N을 사용한 횟수
        numbers = set()
        numbers.add(int(str(N) * i))  # 숫자를 연속해서 붙여서 얻은 결과

        for j in range(i - 1):  # 0~n-1 세트
            for x in dp[j]:  # 첫번째 세트
                for y in dp[-j - 1]:  # 비교할 세트 ->뒤에서 부터 이용
                    numbers.add(x + y)
                    numbers.add(x - y)
                    numbers.add(x * y)
                    if y != 0:
                        numbers.add(x // y)
        if number in numbers:
            answer = i
            break
        dp.append(numbers)
    return answer