n=input()
a=input()
graph=[[]*int(n) for _ in range(int(n)+1)]

for i in range(int(a)):
    x,y=map(int,input().split())
    graph[x].append(y)
    graph[y].append(x)
visit=[]
stack=[1]
while stack:
    cur=stack.pop()
    for j in graph[cur]:
        if not j in visit:
            stack.append(j)
    if not cur in visit:
        visit.append(cur)
print(len(visit)-1)