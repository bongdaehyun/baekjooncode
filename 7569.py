from _collections import deque

m,n,h=map(int,input().split())
maps=[[] for i in range(h)]
q=deque()
dx=[-1,0,1,0,0,0]
dy=[0,1,0,-1,0,0]
dz=[0,0,0,0,1,-1]

for i in range(h):
    for j in range(n):
        maps[i].append(list(map(int,input().split())))
check=True
for i in maps:
    for j in i:
        if 0 in j:
            check=False
            break
if check:
    for z in range(h):
        for y in range(n):
            for x in range(m):
                if maps[z][y][x]==1:
                    q.append((y,x,z))

    day=-1
    while q:
        day+=1
        for _ in range(len(q)):
            a,b,c=q.popleft()
            for k in range(6):
                na,nb,nc=a+dx[k],b+dy[k],c+dz[k]
                if 0<=na<n and 0<=nb<m and 0<=nc<h:
                    if maps[nc][na][nb]==0:
                        maps[nc][na][nb]=1
                        q.append((na,nb,nc))


    for i in maps:
        for j in i:
            if 0 in j:
                day=-1
    print(day)
else:
    print(0)


