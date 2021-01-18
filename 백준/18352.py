import sys

def bfs(start):
    visit=[False]*(N+1)
    q=[start]
    visit[start]=True
    ans=[]
    while q:
        cur=q.pop(0)
        if d[cur]==K:
            ans.append(cur)
        else:
            for c in graph[cur]:
                if visit[c]==False:
                    q.append(c)
                    d[c]=d[cur]+1
                    visit[c]=True

    return ans
N,M,K,X= map(int,sys.stdin.readline().split())
graph=[[] for i in range(N+1)]
d=[0]*(N+1)
for m in range(M):
    a,b=map(int,sys.stdin.readline().split())
    graph[a].append(b)
res=bfs(X)
if res:
    res.sort()
    for r in res:
        print(r)
else:
    print(-1)


