def solution(n, times):
    answer = 0
    start,end,mid=0,times[-1]*n,0
    
    
    while start <= end:
        total=0
        mid=(start+end)//2
        
        for time in times:
            total+=mid//time
            #print("total",mid//time)
        
        if total<n:
            start=mid+1
        else:
            end=mid-1
    
    answer=start
    
    return answer