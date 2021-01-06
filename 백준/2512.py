n=int(input())
moneys=list(map(int,input().split()))
ma=int(input())

moneys.sort()

low=0
high=moneys[-1]

while low <=high:
    mid=(low+high)//2
    money=0
    for i in moneys:
        if mid > i:
            money+=i
        else:
            money+=mid

    if money <= ma:
        res = mid
        low=mid+1
    else:
        high=mid-1

print(res)