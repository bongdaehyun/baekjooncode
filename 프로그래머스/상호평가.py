def solution(scores):
    answer = ''
    for i in range(len(scores)):
        score=[]
        mynum=0
        for j in range(len(scores[i])):
            if i != j:
                score.append(scores[j][i])
            else:
                mynum=scores[j][i]
        #최고 최저 확인
        score=doCheckNum(mynum,score)
        #학점 계산
        answer+=getScore(score,len(score))
    return answer

def doCheckNum(mynum,score):
    minv=min(score)
    maxv=max(score)
    #자기평점을 제외한 평점들 중에서 최고와 최저보다 더낮거나 더 높을경우 
    if mynum < minv or mynum > maxv:
        #유일한 최고나 최저
        return score
    else:
        #최고나 최저랑 같을 경우
        score.append(mynum)
        return score

def getScore(score,lenv):
    sumv=sum(score)
    avg=sumv/lenv
    #print(avg)
    if avg>=90:
        return 'A'
    elif avg>=80:
        return 'B'
    elif avg>=70:
        return 'C'
    elif avg>=50:
        return 'D'
    else:
        return 'F'