def solution(table, languages, preference):
    answer = ''
    maxv=0
    user=dict()
    for i in range(len(languages)):
        user[languages[i]]=preference[i]
    
    for t in table:
        job=t.split(" ")
        
        score=5
        sumv=0
        for j in job[1:]:
            if j in user.keys():
                sumv+=score*user[j]
            score-=1
        #print(job[0],sumv)
        if sumv>maxv:
            answer=job[0]
            maxv=sumv
        elif sumv==maxv:
            sortv=[answer,job[0]]
            sortv.sort()
            answer=sortv[0]
    return answer
