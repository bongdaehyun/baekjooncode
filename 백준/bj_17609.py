import sys

#회문인지 판단
def firstcheck(word,left,right):
    while left< right:
        if word[left]==word[right]:
            left+=1
            right-=1
        else:
            a=twocheck(word,left+1,right)
            b=twocheck(word,left,right-1)
            if a or b:
                return 1
            else:
                return 2
    return 0

#유사회문인지 아닌지 판단
def twocheck(word,left,right):
    while left<right:
        if word[left] == word[right]:
            left += 1
            right -= 1
        else:
            return False
    return True

n=int(sys.stdin.readline());
str_list=[]
for i in range(n):
    word=sys.stdin.readline().rstrip()
    left=0
    right=len(word)-1
    ans=firstcheck(word,left,right)
    print(ans)

