import sys
s = sys.stdin.readline().strip()
bumb_s = sys.stdin.readline().strip()

stack = []
for i in range(len(s)):
    stack.append(s[i])

    if len(stack) >= len(bumb_s):
        check = True
        for j in range(len(bumb_s)):
            if stack[len(stack)-2-j] != bumb_s[j]:
                check = False
                break
        if check:
            for j in range(len(bumb_s)):
                stack.pop()
    print(stack)
