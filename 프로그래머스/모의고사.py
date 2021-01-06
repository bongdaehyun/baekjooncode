def solution(answers):
    answer = []
    p_1=[1,2,3,4,5]*2000
    p_2=[2,1,2,3,2,4,2,5]*1250
    p_3=[3, 3, 1, 1, 2, 2, 4, 4, 5, 5]*1000
    counts=[0,0,0]
    for i in range(len(answers)):
        if answers[i]==p_1[i]:
            counts[0]+=1
        if answers[i]==p_2[i]:
            counts[1]+=1
        if answers[i]==p_3[i]:
            counts[2]+=1
    m=max(counts)
    for idx in range(len(counts)):
        if m==counts[idx]:
            answer.append(idx+1)
    return answer

