from collections import deque
def solution(enter, leave):
    answer = [0]*(len(enter)+1)
    enter=deque(enter)
    leave=deque(leave)
    room=[]
    
    while leave:
        #퇴실인원이 없으면 방에 입실
        while enter and leave[0] not in room:
            room.append(enter.popleft())
        #퇴실
        n=leave.popleft()
        room.remove(n)

        #만났던 사람들 
        for r in room:
            if r != n:
                answer[n]+=1
                answer[r]+=1
    
    return answer[1:]

