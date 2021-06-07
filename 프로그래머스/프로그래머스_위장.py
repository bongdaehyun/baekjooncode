from collections import Counter

def solution(clothes):
    answer = 0
    #각 종류의 개수를 세기
    p=Counter([kind for name, kind in clothes])
    
    cnt=1
    for i in p.values():
        cnt*=(i+1)
    return cnt-1