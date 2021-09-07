#방법 1
def solution(routes):
    answer = 0
    #진입시점으로 해야 다음 차량의 진출 시점과 비교하면서 카메라 설치 유무를 빠르게 판단 
    routes.sort(key=lambda x :x[1])
    #카메라를 만났는지 체크
    checked=[0 for i in range(len(routes))]
    
    for i in range(len(routes)):
        #카메라에 한번도 안만났다면
        if checked[i]==0:
            camera=routes[i][1]
            answer+=1
        for j in range(i+1,len(routes)):
            if routes[j][0] <= camera <=routes[j][1] and checked[j]==0:
                checked[j]=1
            
    return answer

#방법 2
def solution(routes):
    answer = 0
    #진입시점으로 해야 다음 차량의 진출 시점과 비교하면서 카메라 설치 유무를 빠르게 판단 
    routes.sort(key=lambda x :x[1])
    camera=-30001
    
    for route in routes:
        if camera < route[0]:
            answer+=1
            camera=route[1]

                
    return answer