#DFS BFS 연습
from collections import deque

def solution(n, computers):
    answer = 1
    visit=[0]*n
    q=deque()
    q.append(0)
    
    while 0 in visit:
        if q:
            cnt=q.popleft()
            visit[cnt]=1
        
            for i in range(n):
                if computers[cnt][i]==1 and visit[i]==0:
                    q.append(i)
        else:
            idx=visit.index(0)
            q.append(idx)
            answer+=1
        
    
    return answer