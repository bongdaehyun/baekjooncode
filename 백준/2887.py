import heapq
def prim(start,n):
    q = []
    visit=[False]*(n+1)
    cnt=1
    dist=0
    visit[start]=True
    for i in graphs[start]:
        heapq.heappush(q,i)
    while q:
        c,p=heapq.heappop(q)
        if not visit[p]:
            visit[p]=True
            cnt+=1
            dist+=c
            for i in graphs[p]:
                heapq.heappush(q,i)
        if cnt== n:
            return dist

n=input()
N=[]
for _ in range(int(n)):
    a,b,c=map(int,input().split())
    N.append([a,b,c])
d=[]
for i in range(0,len(N)-1):
    for j in range(i+1,len(N)):
        v = min(abs(N[i][0] - N[j][0]), abs(N[i][1] - N[j][1]), abs(N[i][2] - N[j][2]))
        d.append((i+1,j+1,v))
graphs=[[] for _ in range(int(n)+1)]

for i in range(len(d)):
    graphs[d[i][0]].append((d[i][2],d[i][1]))
    graphs[d[i][1]].append((d[i][2],d[i][0]))

print(prim(1,int(n)))