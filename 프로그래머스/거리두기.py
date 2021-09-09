from collections import deque
size=5
d=[[0,1],[0,-1],[1,0],[-1,0]]
def generate_map(place):
    man=[]
    arr=[]
    for i in range(size):
        temp=[]
        for j in range(size):
            if place[i][j]=="P":
                man.append([i,j])
            temp.append(place[i][j])
        arr.append(temp)
    return arr,man

def bfs(arr,men):
    sy=men[0]
    sx=men[1]
    
    visited=[[-1 for _ in range(size)] for _ in range(size)]
    q=deque()
    
    q.append([sy,sx])
    visited[sy][sx]=0
    
    while q:
        y,x=q.popleft()
        
        for k in range(4):
            ny=y+d[k][0]
            nx=x+d[k][1]
            
            if 0<=nx<size and 0<=ny<size and visited[ny][nx]==-1 and arr[ny][nx] !='X':
                visited[ny][nx]=visited[y][x]+1
                q.append([ny,nx])
    return visited

def solution(places):
    answer = []
    for place in places:
        check=True
        arr,man=generate_map(place)
        #print(arr,man)
        for men in man:
            maps=bfs(arr,men)
            
            for m in man:
                if m != men:
                    if -1< maps[m[0]][m[1]]<=2:
                        check=False
                        break
            if not check:
                break
            
        if check:
            answer.append(1)
        else:
            answer.append(0)
    return answer