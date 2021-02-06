#next_permutation

import sys

def next_per():
    idx=-1
    #1. n[i] < n[i+1] 인 높은 인덱스의 위치를 찾는다.
    for i in range(n-1):
        if numbers[i]<numbers[i+1]:
            idx=i
    # 내림차순이면 마지막 순열
    if idx==-1:
        print(-1)
        return
    # 2. idx보다 큰 요소들의 마지막 인덱스 (위치 스왑)
    for i in range(n-1,idx,-1):
        if numbers[idx]<numbers[i]:
            numbers[idx],numbers[i]=numbers[i],numbers[idx]
            break
    # 3. idx+1 이후의 reverse 뒤집기
    left=idx+1
    right=n-1
    while left<right:
        numbers[left],numbers[right]=numbers[right],numbers[left]
        left+=1
        right-=1

    print(*numbers)

n=int(sys.stdin.readline().rstrip())
numbers=list(map(int,sys.stdin.readline().rstrip().split()))

next_per()

