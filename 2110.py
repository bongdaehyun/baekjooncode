#공유기 설치
n,c=map(int,input().split())

house=[]
for _ in range(n):
    house.append(int(input()))

house.sort()
max_dist=house[-1]-house[0]
min_dist=house[1]-house[0]

res=0
while True:
    if min_dist > max_dist:
        break
    mid=(min_dist+max_dist)//2
    count=1
    first=house[0]
    for i in range(1,n):
        if first+mid<=house[i]:
            count+=1
            first=house[i]
            if count==c:
                break
    if count>=c:
        min_dist=mid+1
        res=mid
    else:
        max_dist=mid-1

print(res)