import re

def solution(inp_str):
    answer=[]
    if 8>len(inp_str) or len(inp_str)>15:
        answer.append(1)

    #2번
    flag = [0] * 4
    for s in inp_str:
        if re.compile('[A-Z]').match(s):
            flag[0]=1
        elif re.compile('[a-z]').match(s):
            flag[1]=1
        elif re.compile('[0-9]').match(s):
            flag[2]=1
        elif re.compile('[\~\!\#\$\%\^\&\*]').match(s):
            flag[3]=1
        else:
            answer.append(2)
            break

    # 3번
    if flag.count(1)<3:
        answer.append(3)

    #4번
    sum=0
    idx=0
    ss=inp_str[idx]
    while True:
        if idx==len(inp_str):
            break
        if ss==inp_str[idx]:
            sum+=1
            if sum>=4:
                answer.append(4)
                break
        else:
            ss=inp_str[idx]
        idx+=1

    #5번
    for i in inp_str:
        if inp_str.count(i)>=5:
            answer.append(5)
            break

    if not answer:
        answer.append(0)
    print(answer)


solution("ZzZz9Z824")
#solution("AaTa+!12-3")