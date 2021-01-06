n=int(input())
for i in range(n):
    vpn=[]
    c=[j for j in input()]
    for k in c:
        vpn.append(k)
        top=len(vpn)
        if top > 1:
            if vpn[top-1]==')' and vpn[top-2]=='(':
                vpn.pop()
                vpn.pop()
    if vpn:
        print("NO")
    else:
        print("YES")