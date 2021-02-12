import sys
import copy

#회전연산을 순서대로가 아닌 임의로 해서 돌린 뒤 그 중 최소값을 찾는 문제
dx=[1,0,-1,0] # 하 우 상 좌
dy=[0,1,0,-1]
n,m,k=map(int,sys.stdin.readline().split())
maps=[]
#N * M 배열 입력
for _ in range(n):
    a=list(map(int,sys.stdin.readline().split()))
    maps.append(a)

def spin(r,c,s,ary):
    sx,sy=r-s-1,c-s-1
    ex,ey=r+s-1,c+s-1
    #사각형 개수
    mins=(2*s+1)//2
    #사각형 회전
    for m in range(mins):
        d=0
        stack = [[sx, sy]]
        temp=ary[sx][sy]
        while d<4:
            x,y=stack.pop()
            nx=x+dx[d]
            ny=y+dy[d]
            if sx<=nx<=ex and sy<=ny<=ey:
                ary[x][y]=ary[nx][ny]
                stack.append([nx,ny])
            else:
                d+=1
                stack.append([x,y])
        ary[sx][sy+1]=temp
        sx+=1
        sy+=1
        ex-=1
        ey-=1
    return ary

# 회전 연산 저장
mins=sys.maxsize
rotates=[]
for _ in range(k):
    r,c,s=map(int, sys.stdin.readline().split())
    rotates.append([r,c,s])

Issel=[False]*len(rotates)
picks=[]
def permutation(cnt):
    global mins
    if cnt==k:# 회전연산 계산
        #ary = copy.deepcopy(maps) #deepcopy는 시간이오래걸린다.
        ary=[row[:] for row in maps]
        for p in picks:
            r,c,s=p
            ary=spin(r,c,s,ary)
        #행 계산
        for i in range(n):
            mins=min(mins,sum(ary[i]))
        return
    for i in range(k):
        if Issel[i]: continue
        Issel[i]=True
        picks.append(rotates[i])
        permutation(cnt+1)
        Issel[i]=False
        picks.pop()

permutation(0)
print(mins)



