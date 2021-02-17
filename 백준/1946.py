import sys
t=int(sys.stdin.readline())
for _ in range(t):
    p=[]
    n=int(sys.stdin.readline())
    #다른 모든 지원자와 비교했을때 서류 심사 성적과
    #면접 성적중 적어도 하나가 다 른지원자보다 높아야된다!.
    for i in range(n):
        p.append(list(map(int,sys.stdin.readline().split())))
    p=sorted(p,key=lambda x:(x[0],x[1]))
    print(p)