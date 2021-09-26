from collections import deque

def bfs(begin,target,words):
    visit=[0]*len(words)
    q=deque()
    q.append([begin,0])
    while q:
        word,num=q.popleft()
        if word==target:
            return num
        
        for i in range(len(words)):
            if visit[i]==0:
                right=0
                for j in range(len(words[i])):
                    if word[j] != words[i][j]:
                        right+=1
                        
                if right==1:
                    q.append([words[i],num+1])
                    visit[i]=1
    
    

def solution(begin, target, words):
    answer = 0
    if target in words:
        answer=bfs(begin, target, words)
    else:
        pass
    return answer