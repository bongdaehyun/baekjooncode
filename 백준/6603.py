import sys

def combi(cnt,start):
    if cnt==6:
        print(*res)
        return
    for i in range(start,n):
        res.append(nums[i])
        combi(cnt+1,i+1)
        res.pop()
while True:
    nums=list(map(int,sys.stdin.readline().split()))
    n=nums.pop(0)
    if n==0:
        break
    res=[]
    combi(0,0)
    print()