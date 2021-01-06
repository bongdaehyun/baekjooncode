def factorial(n):
    if n==1:
        return 1
    elif n==0:
        return 0
    else:
        return n*factorial(n-1)

n,m=map(int,input().split())
if n>0:
    result=factorial(n)//(factorial(m)*factorial(n-m))
    z=[i for i in str(result)]
    idx=len(z)-1
    count=0
    while True:
        if z[idx]=='0':
            count+=1
            idx-=1
        else:
            break
else:
    count=0
print(count)