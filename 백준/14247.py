import sys
n=int(sys.stdin.readline())
trees=[[int(i)] for i in sys.stdin.readline().split()]
cnt=0
for i in sys.stdin.readline().split():
    trees[cnt].append(int(i))
    cnt+=1
trees=sorted(trees,key=lambda x:x[1])

ans=trees[0][0]
for i in range(1,n):
    ans+=trees[i][0]+trees[i][1]*i
print(ans)