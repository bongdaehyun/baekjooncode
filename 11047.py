n,k=map(int,input().split())
coins=[]
for _ in range(n):
    coins.append(int(input()))

coins.reverse()
count=0
for coin in coins:
    if k//coin !=0:
        count+=(k//coin)
        k=k%coin
        if k==0:
            break
print(count)
