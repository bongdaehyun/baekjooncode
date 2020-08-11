n=[]
for _ in range(int(input())):
    n.append(input())
k=len(n[0])-1
idx=len(n)-1
while True:
    if n[idx][k:]==n[idx-1][k:]:
        idx-=1
        if idx ==0:
            idx=len(n)-1
            