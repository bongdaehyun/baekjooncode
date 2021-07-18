import sys

def solution(distance, rocks, n):
    answer = 0
    rocks.sort() # 징검다리 정렬
    rocks.append(distance) # 마지막 위치의 거리추가
    
    left=0
    right=distance
    #mid == 거리의 최솟값
    while left<=right:
        mid=(left+right)//2
        min_dis=sys.maxsize
        remove_rock=0 # 제거한 바위 개수
        cnt=0 # 현재 위치
        
        #각 바위의 거리 재기
        for rock in rocks:
            dis=rock-cnt #바위와 현재 위치사이의 거리
            
            if dis<mid: # mid 보다 작으면 제거
                remove_rock+=1
            else: # mid보다 크면 바위 그대로
                cnt=rock # 현재 위치 수정
                min_dis=min(dis,min_dis)#최소 거리 갱신
            
        #mid 갱신
        if remove_rock<=n: #제거한 바위의 개수가 n개 이하인경우 left 수정
            left=mid+1
            answer=min_dis
        else:
            #제거한 바위의 개수가 n개 보다 많은 경우 right 수정
            right=mid-1
        
    return answer