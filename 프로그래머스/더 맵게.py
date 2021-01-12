import heapq

def solution(scoville, K):
    answer = 0
    heap=[]
    for num in scoville:
        heapq.heappush(heap,num)
    while(True):
        if heap[0]>=K:
            break
        if len(heap) >1:
            most=heapq.heappop(heap)
            most2=heapq.heappop(heap)

            new_num=most+most2*2
            heapq.heappush(heap,new_num)
            answer+=1
        else:
            return -1
    return answer