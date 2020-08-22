from _collections import deque

def topologysort():
    result=[]
    q = deque()

    #정점이 0인것들 queue 삽입
    for i in range(1,n+1):
        if indegree[i]==0:
            q.insert(0,i)

    #사이클이면 함수 종료
    while q:
        x=q.popleft()
        result.append(x)
        for j in graphs[x]:
            indegree[j]-=1
            if indegree[j]==0:
                q.insert(0,j)
    for k in result:
        print(k,end=" ")

if __name__ == '__main__':

    n,m=map(int,input().split())
    indegree=[0]*(n+1)
    graphs=[[] for _ in range(n+1)]
    for _ in range(m):
        a,b=map(int,input().split())
        graphs[a].append(b)
        indegree[b]+=1
    topologysort()