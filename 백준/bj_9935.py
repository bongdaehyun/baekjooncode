import sys
s = sys.stdin.readline().strip()
bumb_s = sys.stdin.readline().strip()

# 328ms 풀이
# 폭발 문자열의 마지막 문자를 이용하여 판단
b_last = bumb_s[-1]
blen = len(bumb_s)
bumbl = list(bumb_s)
stack = []
for char in s:
    stack.append(char)
    if char == b_last and bumbl == stack[-blen:]:
        del stack[-blen:]

print(''.join(stack) if stack else "FRULA")


# 내가 한 풀이 시간 1440ms
# stack = []
# for i in range(len(s)):
#     stack.append(s[i])

#     if len(stack) >= len(bumb_s):
#         check = True
#         for j in range(len(bumb_s)):

#             if stack[len(stack)-1-j] != bumb_s[len(bumb_s)-1-j]:
#                 check = False
#                 break
#         if check:
#             for j in range(len(bumb_s)):
#                 stack.pop()

# if stack:
#     print("".join(stack))
# else:
#     print("FRULA")
