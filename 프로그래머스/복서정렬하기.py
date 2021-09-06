def solution(weights, head2head):
    answer = []
    people=[]
    #승률 계산
    for i in range(len(head2head)):
        roundv,winv,score,w,heavy_win=0,0,0,weights[i],0
        
        for j in range(len(head2head[i])):
            if head2head[i][j] =="N":
                continue
            elif head2head[i][j]=="W":
                if w < weights[j]:
                    heavy_win+=1
                winv+=1
            roundv+=1
        
        if winv !=0:
            score=(winv/roundv)*100
        
        result=[i+1,score,heavy_win,w]
        people.append(result)
    #print(people)
    e = sorted(people, key = lambda x : (-x[1],-x[2],-x[3],x[0]))
    for n in e:
        answer.append(n[0])
    return answer


