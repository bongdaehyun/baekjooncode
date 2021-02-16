import sys
n=int(sys.stdin.readline())

ary=[]
for i in range(n):
    ary.append(list(map(int,sys.stdin.readline().split())))

ary=sorted(ary,key=lambda x:(x[1],x[0]))
#print(ary)
temp=ary[0]
count=1
for i in range(1,len(ary)):
    if temp[1]<=ary[i][0]:
        count+=1
        temp=ary[i]
        #print(ary[i])
print(count)