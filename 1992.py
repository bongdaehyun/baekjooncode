#분할 정복

def quadtree(x,y,n):
    global res
    mid=n//2
    count=0
    for i in range(x,x+n):
        for j in range(y,y+n):
            if m[i][j]==1:
                count+=1

    if count==0:
        res+="0"
    elif count==n**2:
        res+="1"
    else:
        res+="("
        quadtree(x, y, mid)
        quadtree(x, y + mid, mid)
        quadtree(x+mid, y, mid)
        quadtree(x+mid, y+mid, mid)
        res+=")"

n=int(input())
m=[]
res=""
for _ in range(n):
    a=[int(i) for i in input()]
    m.append(a)

quadtree(0,0,n)
print(res)