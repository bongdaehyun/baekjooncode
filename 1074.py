def makenumber(x, y, n):
    global count
    mid = n // 2

    if n <= 2:
        if x == r and y == c:
            print(count)
            return
        count += 1

        if x == r and y+1 == c:
            print(count)
            return
        count += 1

        if x+1 == r and y == c:
            print(count)
            return
        count += 1

        if x+1 == r and y+1 == c:
            print(count)
            return
        count += 1
    else:
        makenumber(x,y,mid)
        makenumber(x, y+mid, mid)
        makenumber(x+mid, y, mid)
        makenumber(x+mid, y+mid, mid)

n,r,c=map(int,input().split())
count=0
makenumber(0,0,2**n)
