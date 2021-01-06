
def colorpaper(x,y,n):
    global blue,white
    mid=n//2

    count=0

    for i in range(x,x+n):
        for j in range(y,y+n):
            if m[i][j]==1:
                count+=1

    if count==0:
        white+=1
    elif count==n**2:
        blue+=1
    else:
        colorpaper(x,y,mid)
        colorpaper(x+mid,y,mid)
        colorpaper(x,y+mid, mid)
        colorpaper(x+mid, y+mid, mid)


n=int(input())
m=[]
for _ in range(n):
    m.append(list(map(int,input().split())))

blue=0
white=0
colorpaper(0,0,n)
print(white)
print(blue)