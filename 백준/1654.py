k,n=map(int,input().split())
lines=[]
for _ in range(k):
    lines.append(int(input()))

lines.sort()
min_lenght=1
max_lenght=lines[-1]
res=0
while min_lenght<=max_lenght:
    cur=0
    mid=(min_lenght+max_lenght)//2

    for i in lines:
        cur+=(i//mid)
    if cur < n: # 잘라낸 개수가 작으면 더 작은 단위로 잘라야됨
        max_lenght=mid-1
    else: # 잘라낸 개수가 많다면 더 큰 단위로 잘라야됨
        res = mid
        min_lenght=mid+1

print(res)