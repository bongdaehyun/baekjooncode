import sys
sys.setrecursionlimit(10000) # 재귀 허용깊이 임의로 지정

def solution(k, room_number):
    answer = []
    rooms=dict() #방번호: 바로 다음 빈 방 번호
    
    for n in room_number:
        emptynum=findemptyroom(n,rooms)
        answer.append(emptynum)
    return answer

def findemptyroom(num,rooms):
    if num not in rooms: # 빈방이면 번호 반환
        rooms[num]=num+1
        return num
    #이미 배정된 번호라면
    empty=findemptyroom(rooms[num],rooms)#재귀를 이용하여 다음 빈방 번호 반환
    rooms[num]=empty+1
    return empty
    
    