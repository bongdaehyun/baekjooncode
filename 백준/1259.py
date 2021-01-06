while True:
    n=input()
    if n=='0':
        break
    num=[i for i in n]

    mid=len(num)//2
    if len(num)%2!=0:
        k=num[mid:]
        del k[0]
    else:
        k=num[mid:]
    l=num[:mid]
    l.reverse()
    if k==l:
        print("yes")
    else:
        print("no")