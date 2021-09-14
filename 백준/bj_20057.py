# 못풀어서 해설보고 풀엇음..
import sys

n=int(sys.stdin.readline())
maps=[ list(map(int,sys.stdin.readline().split())) for _ in range(n)]
dx=[0,1,0,-1]
dy=[-1,0,1,0]

def move_sand(x,y,sand):
    global ans
    if 0<=x<n and 0<=y<n:
        maps[x][y]+=sand
    else:
        ans+=sand
        #print("실행",sand)
x,y=n//2,n//2 
ans,move,d,cnt,turn=0,0,0,0,1
while True:
    nx=x+dx[d]
    ny=y+dy[d]
    #움직이는 곳에 모래가 있다면
    if maps[nx][ny]:
        v1=int(maps[nx][ny]*0.01)
        v2=int(maps[nx][ny]*0.02)
        v5=int(maps[nx][ny]*0.05)
        v7=int(maps[nx][ny]*0.07)
        v10=int(maps[nx][ny]*0.1)
        
        temp=maps[nx][ny]-2*(v1+v2+v7+v10)-v5

        v1xu,v1yu=x+dx[(d+3)%4],y+dy[(d+3)%4]
        v1xd,v1yd=x+dx[(d+1)%4],y+dy[(d+1)%4]
        v2xu,v2yu=nx+2*dx[(d+3)%4],ny+2*dy[(d+3)%4]
        v2xd,v2yd=nx+2*dx[(d+1)%4],ny+2*dy[(d+1)%4]
        v7xu,v7yu=nx+dx[(d+3)%4],ny+dy[(d+3)%4]
        v7xd,v7yd=nx+dx[(d+1)%4],ny+dy[(d+1)%4]
        
        tx,ty=nx+dx[d],ny+dy[d]
        v10xu,v10yu=tx+dx[(d+3)%4],ty+dy[(d+3)%4]
        v10xd,v10yd=tx+dx[(d+1)%4],ty+dy[(d+1)%4]
        v5x,v5y=tx+dx[d],ty+dy[d]

        move_sand(v1xu,v1yu,v1)
        move_sand(v1xd,v1yd,v1)
        move_sand(v2xu,v2yu,v2)
        move_sand(v2xd,v2yd,v2)
        move_sand(v7xd,v7yd,v7)
        move_sand(v7xu,v7yu,v7)
        move_sand(v10xd,v10yd,v10)
        move_sand(v10xu,v10yu,v10)
        move_sand(v5x,v5y,v5)
        move_sand(tx,ty,temp)
    #print(ans)
    if x==0 and y==0:
        break
    x,y=nx,ny
    maps[nx][ny]=0
    cnt+=1
    if cnt==turn:
        cnt=0
        d=(d+1)%4
        move+=1
        if move%2==0:
            move=0
            turn+=1

print(ans)