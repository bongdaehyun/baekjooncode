import sys
t=int(sys.stdin.readline())
for _ in range(t):
    p=[]
    n=int(sys.stdin.readline())
    #다른 모든 지원자와 비교했을때 서류 심사 성적과
    #면접 성적중 적어도 하나가 다 른지원자보다 높아야된다!.
    for i in range(n):
        p.append(list(map(int,sys.stdin.readline().split())))
    p=sorted(p,key=lambda x:x[0])
    #서류 순위 별로 오름차순 후 순위가 같다면 면접 순위오름차순
    ans=1
    temp=p[0]
    for i in range(1,len(p)):
        if temp[1]>p[i][1]:
            ans+=1
            temp=p[i]
    print(ans)