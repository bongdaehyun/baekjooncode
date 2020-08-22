def findnumber(target):

    low=0
    high=n-1
    check=False
    while low<=high:
        mid=(low+high)//2

        if n_list[mid]==target:
            check=True
            break
        elif n_list[mid] < target:
            low=mid+1
        else:
            high=mid-1

    if check:
        print(1)
    else:
        print(0)

n=int(input())
n_list=list(map(int,input().split()))
m=int(input())
m_list=list(map(int,input().split()))

n_list.sort()
for i in m_list:
    findnumber(i)
