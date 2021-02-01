import sys
from _collections import deque
a,b,n=map(int,sys.stdin.readline().split())
q=deque([])
for _ in range(n):
    t,c,m=sys.stdin.readline().split()
    q.append([int(t),c,int(m)])
