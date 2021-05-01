def solution(s):
    answer = []
    #숫자끼리 그룹생성
    slist=s.replace("{","").split("}")
    #print(slist)
    #생성된 그룹들을 원소별로 int형으로 변환
    result=[]
    for i in range(len(slist)):
        if slist[i]=='':
            continue
        if i==0:
            result.append(list(map(int,slist[i].split(','))))
        else:
            temp=slist[i][1:].split(',')
            result.append(list(map(int,temp)))
    #print(result)
    #count세기
    dic={}
    for i in result:
        for n in i:
            if n in dic:
                dic[n]+=1
            else:
                dic[n]=1
    #자주 등장한 숫자부터 출력
    res=sorted(dic.items(),key=lambda x:x[1],reverse=True)
    for r in res:
        answer.append(r[0])
    return answer