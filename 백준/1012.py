dx=[-1,0,1,0]
dy=[0,-1,0,1]
ji_num=[]
for i in range(int(input())):
    a,b,n=map(int,input().split())
    maps=[[0 for _ in range(b)] for _ in range(a)]
    visit=[[False]*b for _ in range(a)]
    ji=0
    for j in range(n):
        x,y=map(int,input().split())
        maps[x][y]=1
    for x in range(a):
        for y in range(b):
            if maps[x][y]==1 and visit[x][y]==False:
                visit[x][y]=True
                ji+=1
                stack=[(x,y)]
                while stack:
                    x_,y_=stack.pop()
                    for k in range(4):
                        nx,ny=x_+dx[k],y_+dy[k]
                        if 0<=nx<a and 0<=ny<b:
                            if visit[nx][ny]==False and maps[nx][ny]==1:
                                visit[nx][ny]=True
                                stack.append((nx,ny))
    ji_num.append(ji)
for o in ji_num:
    print(o)