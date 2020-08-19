from collections import deque
q=deque()
dx=[-1,0,1,0]
dy=[0,1,0,-1]
x,y=map(int,input().split())
maps=[]
for i in range(y):
    row=[int(l) for l in input().split()]
    for j in range(x):
        if row[j]==1:
            q.append((i,j))
    maps.append(row)

time=-1
while q:
    time += 1
    for _ in range(len(q)):
        x_,y_=q.popleft()
        for k in range(4):
            nx,ny=x_+dx[k],y_+dy[k]
            if 0<=nx<y and 0<=ny<x:
                if maps[nx][ny]==0 :
                    q.append((nx,ny))
                    maps[nx][ny]=1
for c in maps:
    if 0 in c:
        time=-1
print(time)