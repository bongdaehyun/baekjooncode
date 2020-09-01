from _collections import deque
def bfs(x,y):
    q=deque()
    visit=[]
    q.append((x,y))
    while q:
        x,y=q.popleft()
        if x==x1 and y==y1:
            print("happy")
            return
        for nx,ny in a:
            if (nx,ny) not in visit:
                dist=abs(nx-x)+abs(ny-y)
                if 1000 >= dist:
                    q.append((nx,ny))
                    visit.append(((nx,ny)))
    print("sad")
    return

t=int(input())
for _ in range(t):
    n=int(input())
    a=[]
    x0,y0=map(int,input().split())
    for _ in range(n):
        x,y=map(int,input().split())
        a.append((x,y))
    x1,y1=map(int,input().split())
    a.append((x1,y1))
    bfs(x0,y0)
