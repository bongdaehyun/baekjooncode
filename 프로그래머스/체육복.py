def solution(n, lost, reserve):
    answer = 0
    left_reserve = list(set(reserve) - set(lost))
    left_lost = list(set(lost)-set(reserve))
    answer = n - len(left_lost)
    for i in left_reserve:
        if i-1 in left_lost:
            answer += 1
            left_lost.remove(i-1)
        elif i+1 in left_lost:
            answer += 1
            left_lost.remove(i+1)

    return answer