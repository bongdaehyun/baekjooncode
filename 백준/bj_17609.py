import sys
n=int(sys.stdin.readline());
str_list=[]
for i in range(n):
    str_list.append([i for i in sys.stdin.readline().rstrip()])

ans=[]
for s in str_list:
    check=False #2번들어가는 걸 방지 ex) flag
    flag=False #유사회문 판단
    left=0
    right=len(s)-1
    while left<right:
        if s[left]!=s[right]:
           if flag:
               ans.append(2)
               check=True
               break
           else:
               flag=True
               if s[left + 1] == s[right]:
                   left+=1
               elif s[left] == s[right-1]:
                   right-=1
               else:
                   ans.append(2)
                   check=True
                   break
        left+=1
        right-=1
    if not check and flag:
        ans.append(1)
    elif not check and not flag:
        ans.append(0)
for i in ans:
    print(i)