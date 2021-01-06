n=int(input())

people=list(map(int,input().split()))
people.sort()

min=0
tmp=0
for i in range(n):
    tmp+=people[i]
    min+=tmp

print(min)