import sys
a,b=map(int,sys.stdin.readline().split())
n=[]
for i in range(1,a+1):
   n.append(i)
check=[False]*a

temp=[]
def dfs(num):
    if num==b:
        for i in range(b):
            print(temp[i], end=' ')
        print()
        return
    for i in range(a):
        temp.append(n[i])
        dfs(num+1)
        temp.pop()
        check[i]=False
dfs(0)