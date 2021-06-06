def solution(record):
    answer = []
    #아이디: 닉네임 저장
    id_list=dict()
    
    for r in record:
        #command, userid, username로 분리
        c=r.split()
        #print(c)
        if c[0] =="Enter":
            answer.append([c[0],c[1]])
            #닉네임은 중복가능
            id_list[c[1]]=c[2]
        elif c[0]=="Leave":
            answer.append([c[0],c[1]])
        else:#change
            id_list[c[1]]=c[2]

    #print(id_list)
    result=[]
    for ans in answer:
        if ans[0]=="Enter":
            result.append(id_list[ans[1]]+"님이 들어왔습니다.")
        else:
            result.append(id_list[ans[1]]+"님이 나갔습니다.")
    return result