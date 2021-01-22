import sys
N=int(sys.stdin.readline())
n_list=list(map(int,sys.stdin.readline().split()))
#터진 풍선 체크
visit=[False]*N
#1번 풍선부터 터짐
idx=0
move=n_list[idx]
ans=[1]
visit[0]=True
#나머지 풍선 터트리기
for i in range(N-1):
    #터질 풍선 인덱스로 이동
    idx+=move
    #풍선 인덱스 범위에 나가게 되면 재조정
    if idx>=len(n_list):
        idx-=len(n_list)
    elif idx<0:
        idx+=len(n_list)

    if visit[idx]:
        #오른쪽을 이동
        if move>0:
            while visit[idx]:
                idx+=1
                if idx >= len(n_list):
                    idx -= len(n_list)
        else:
            while visit[idx]:
                idx-=1
                if idx < 0:
                    idx += len(n_list)

    visit[idx]=True
    move=n_list[idx]
    ans.append(idx+1)
    print(visit)
print(ans)
