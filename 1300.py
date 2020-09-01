n=int(input())
k=int(input())

low=0
high=k
res=0
while low <= high:
    mid=(low+high)//2
    temp=0
    for i in range(1,n+1):
        temp+=min(mid//i,n)

    if temp <k:
        low=mid+1
    else:
        res=mid
        high=mid-1
print(res)
