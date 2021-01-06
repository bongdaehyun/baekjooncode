times=[]
for _ in range(int(input())):
    a,b=map(int,input().split())
    times.append((a,b))

times=sorted(times,key=lambda x: x[0])
times=sorted(times,key=lambda x: x[1])

count=1
end=times[0][1]
for i in range(1,len(times)):
    if end <= times[i][0]:
        end=times[i][1]
        count+=1

print(count)