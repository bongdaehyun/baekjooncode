from _collections import deque
a,b,c=map(int,input().split())
edgeList=[]
finalList=[[] for _ in range(a+1)]
for i in range(b):
    f=list(map(int, input().split()))
    edgeList.append(f)
    t=list(reversed(f))
    edgeList.append(t)
for edge in edgeList:
    finalList[edge[0]].append(edge[1])
for i in finalList:
    i.sort()
def bfs(start):
    visit=[]
    q=deque()
    q.append(start)
    while q:
        cur=q.popleft()
        for neighbor in finalList[cur]:
            if not neighbor in visit:
                q.append(neighbor)
        if not cur in visit:
            visit.append(cur)
    return visit
def dfs(start):
    visit=[]
    stack = [start]
    while stack:
        current=stack.pop()
        final=reversed(finalList[current])
        for neighbor in final:
            if not neighbor in visit:
                stack.append(neighbor)
        if not current in visit:
            visit.append(current)
    return visit
dfslist=dfs(c)
for k in dfslist:
    print(k,end=" ")
print()
bfslist=bfs(c)
for k in bfslist:
    print(k,end=" ")