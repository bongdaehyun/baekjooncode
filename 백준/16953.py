import sys
from _collections import deque

a,b=map(int,sys.stdin.readline().split())
q=deque()
q.append([a,0])
ans=sys.maxsize
while q:
    num,count=q.popleft()
    if num==b:
        ans=min(ans,count)
        continue
    if num>b:
        continue
    q.append([num*2,count+1])
    s=str(num)+'1'
    #print(s)
    q.append([int(s),count+1])

if ans==sys.maxsize:
    print(-1)
else:
    print(ans+1)
