def solution(sizes):
    answer = 0
    result=[]
    for size in sizes:
        size.sort(reverse=True)
        result.append(size)
    maxx=0
    maxy=0
    for x,y in result:
        if maxx<x:
            maxx=x
        if maxy<y:
            maxy=y
    answer=maxx*maxy
    return answer

#다른 사람풀이

def solution(sizes):
    return max(max(x) for x in sizes) * max(min(x) for x in sizes)