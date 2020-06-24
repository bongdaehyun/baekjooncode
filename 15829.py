L=int(input())
s=input()
hash_val={}
for i in range(1,27):
    hash_val[chr(96+i)]=i
r=31
num=0
for i in range(len(s)):
    val=hash_val[s[i]]
    num+=val*(r**(i))
print(num%1234567891)