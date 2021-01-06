from collections import deque
dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]
q = deque()
a,b=map(int,input().split())
#거리 측정
d=[[0 for col in range(b)] for row in range(a)]
#방문 체크
visit=[[False]*b for _ in range(a)]
#미로
miro=[list(map(int,input())) for _ in range(a)]
print(miro)
# 0,0 시작
q.append((0,0))
visit[0][0]=True
d[0][0]=1

while q:
    x,y=q.popleft()
    for k in range(4):
        next_x,next_y=x+dx[k],y+dy[k]
        if 0<=next_x<a and 0<=next_y<b:
            if visit[next_x][next_y]==False and miro[next_x][next_y]==1:
                q.append((next_x,next_y))
                visit[next_x][next_y]=True
                d[next_x][next_y]=d[x][y]+1
print(d[a-1][b-1])

