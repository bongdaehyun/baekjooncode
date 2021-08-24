def solution(price, money, count):
    answer = -1
    sumv=0
    for i in range(1,count+1):
        sumv+=i*price
    
    if money<sumv:
        answer=sumv-money
    else:
        answer=0
    return answer