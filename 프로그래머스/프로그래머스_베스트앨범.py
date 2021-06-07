def solution(genres, plays):
    answer = []
    genre_list=dict()# 장르별 재생횟수
    number=dict() #고유 번호 및 재생횟수
    #장르별 노래 재생횟수
    for i in range(len(genres)):
        if genres[i] not in genre_list:
            genre_list[genres[i]]=plays[i]
            number[genres[i]]=[(plays[i],i)]
        else:
            genre_list[genres[i]]+=plays[i]
            number[genres[i]].append((plays[i],i))
            
    #재생횟수 장르 내림차순
    p=sorted(genre_list.items(),key=lambda x: x[1],reverse=True)
    #print(p)
    
    #장르 내에서 많이 재생된 노래 내림차순 고유번호 오름차순, 두 개씩 모음
    for i in number.keys():
        number[i]=sorted(number[i],key=lambda x:(-x[0],x[1]))[:2]
    #print(number.items())
    
    for i in p:
        for j in number[i[0]]:
            answer.append(j[1])
    return answer