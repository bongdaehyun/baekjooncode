#시간초과...
n,m=map(int,input().split())
tree=list(map(int,input().split()))

tree.sort()
low=1
high=tree[-1]

res=0
while low<=high:
    cur=0
    mid=(low+high)//2
    for i in tree:
        if i-mid >= 0:
            cur+=(i-mid)

    if cur >= m: # 잘라낸 나무의 길이가 크면 높이를 더 높게 해서 길이를 줄인다
        if res<mid:
            res=mid
        low=mid+1
    else: # 잘라낸 나무의 길이가 작다면 높이를 더작게 해서 길이를 늘린다
        high=mid-1

print(res)