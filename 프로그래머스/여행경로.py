
def solution(tickets):
    answer=[]
    visit=[0]*len(tickets)
    def dfs(start,end,tickets,num,lent,visit):
    
        if num==lent:
            answer.append(end)
            return

        for i in range(len(tickets)):
            if visit[i]==0 and tickets[i][0]==start:
                visit[i]=1
                dfs(tickets[i][1],end+","+tickets[i][1],tickets,num+1,lent,visit)
                visit[i]=0
                
    dfs("ICN","ICN",tickets,0,len(tickets),visit)
    ans=[]
    for a in answer:
        a=a.split(",")
        #print(a)
        ans.append(a)
    ans.sort()
    
    return ans[0]