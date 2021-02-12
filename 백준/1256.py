import sys

n,m,k=map(int,sys.stdin.readline().split())
start='a'*n+'z'*m

check=[False]*(n+m)
sel=[0]*(n+m)
count=0
def dfs(cnt):
    global count
    if cnt==n+m:
        count+=1
        if count==k:
            print()
        return
