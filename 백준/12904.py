def sum_hw(*arg):

    sumv=0 #int 정수
    for i in arg:# i =리스트
       sumv+=i
    for i in range(1,200):
        if i%2==1:
            sumv+=i
    lists=list(*arg)
    print(lists)
    return sumv

result=sum_hw(*[1,2,3])
print(result)