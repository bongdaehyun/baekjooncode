#내일 다시 풀어보기 https://www.acmicpc.net/problem/20056
import sys
from collections import deque

dx=[-1,-1,0,1,1,1,0,-1]
dy=[0,1,1,1,0,-1,-1,-1]

n,m,k=map(int,sys.stdin.readline().split())
q=deque()
maps=[[deque() for _ in range(n)] for _ in range(n)]
#파이어볼 정보
for i in range(m):
    r,c,m,s,d=map(int,sys.stdin.readline().split())
    q.append([r-1,c-1])
    maps[r-1][c-1].append([m,s,d])

for _ in range(k):
    temp=[]
    qlen=len(q)
    #파이어볼 이동
    for _ in range(qlen):
        x,y=q.popleft()
        for _ in range(len(maps[x][y])):
            m,s,d=maps[x][y].popleft()
            nx=(x+s*dx[d])%n
            ny=(y+s*dy[d])%n
            q.append([nx,ny])
            #temp.append([nx,ny,m,s,d])
            maps[nx][ny].append([m,s,d])
        
    # for x,y,m,s,d in temp:
    #     maps[x][y].append([m,s,d])
    print(maps)
    #2개이상의 파이어볼이 같은 칸에있다면
    for i in range(n):
        for j in range(n):
            if len(maps[i][j])>1:
                nm,ns,check,even,odd=0,0,0,0,0
                for idx,[m,s,d] in enumerate(maps[i][j]):
                    nm+=m
                    ns+=s
                    if idx==0:
                        if d%2==0:
                            even=1
                        else:
                            odd=1
                    else:
                        #다른방향일때
                        if even==1 and d%2==1:
                            check=1
                        elif odd==1 and d%2==0:
                            check=1
                
                nm//=5
                ns//=len(maps[i][j])
                maps[i][j]=deque()
                if nm != 0:
                    for k in range(4):
                        #0246
                        if check==0:
                            nd=k*2
                        else: #1357
                            nd=k*2+1
                        maps[i][j].append([nm,ns,nd])
    print(maps)
ans=0
for i in range(n):
    for j in range(n):
        if maps[i][j]:
            for m,s,d in maps[i][j]:
                ans+=m
print(ans)
