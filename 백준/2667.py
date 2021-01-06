maps=[]
n=int(input())
for i in range(n):
    maps.append([int(j) for j in input()])
visit=[[False]*n for _ in range(n)]
print(maps)
d=[]
dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]
for x in range(n):
    for y in range(n):
        if maps[x][y]==1 and visit[x][y]==False:
            visit[x][y]=True
            dist=1
            stack=[(x,y)]
            while stack:
                nx,ny=stack.pop()
                for k in range(4):
                    next_x, next_y = nx + dx[k],ny + dy[k]
                    if 0<=next_x<n and 0<=next_y<n:
                        if visit[next_x][next_y]==False and maps[next_x][next_y]==1:
                            stack.append((next_x,next_y))
                            visit[next_x][next_y]=True
                            dist+=1
            d.append(dist)
print(len(d))
d.sort()
for i in d:
    print(i)