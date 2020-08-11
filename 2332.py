import sys

def chain(idx):
    Left = idx
    Light = idx
    lpower = z[idx]
    rpower = z[idx]
    # 왼쪽 연쇄
    while Left > 0:
        Left -= 1
        if lpower > z[Left] > 0:
            check[Left] = 1
            lpower = z[Left]
        else:
            break
    # 오른쪽 연쇄
    while Light < len(z) - 1:
        Light += 1
        if rpower > z[Light] > 0:
            check[Light] = 1
            rpower = z[Light]
        else:
            break

if __name__ =='__main__':
    z=[]
    for _ in range(int(sys.stdin.readline())):
        z.append(int(sys.stdin.readline()))
    check=[0]*len(z)
    result=[]
    idx=0
    while True:
        if idx <len(z)-1:
            if z[idx] > z[idx+1] and check[idx]==0:
                check[idx]=1
                result.append(idx+1)
                chain(idx)
            elif z[idx] ==z[idx+1] and check[idx]==0:
                check[idx] = 1
                result.append(idx + 1)
                chain(idx)
        elif idx==len(z)-1 and check[idx]==0:
            check[idx]=1
            result.append(idx + 1)
            chain(idx)
        else:
            break
        idx+=1
        if check.count(1)==len(z):
            break
    for i in result:
        print(i)