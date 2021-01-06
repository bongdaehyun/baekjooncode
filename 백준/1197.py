import heapq
def prim(start):
    q = []
    visit=[False]*(v+1)
    cnt=1
    d=0
    visit[start]=True
    for i in graphs[start]:
        heapq.heappush(q,i)

    while q:
        c,p=heapq.heappop(q)
        print(q)
        if not visit[p]:
            visit[p]=True
            cnt+=1
            d+=c
            for i in graphs[p]:
                heapq.heappush(q,i)
        if cnt== v:
            return d

v, e = map(int, input().split())
graphs = [[] for _ in range(v + 1)]

for _ in range(e):
    a, b, c = map(int, input().split())
    graphs[a].append((c, b))
    graphs[b].append((c, a))
print(prim(1))