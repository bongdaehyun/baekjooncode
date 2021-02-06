import sys

def check():
    stack = []
    for c in gwalho:
        if c == '(' or c == '[':
            stack.append(c)
        else:
            if c == ')' and stack[-1] == '(':
                stack.pop()
            elif c == ']' and stack[-1] == '[':
                stack.pop()
            else:
                stack.append(c)

    if stack:
        return False
    else:
        return True


def cal():
    stack = []
    for c in gwalho:
        if c == '(' or c == '[':
            stack.append(c)
        else:
            if c == ')':
                if stack[-1] == '(':
                    stack[-1] = 2
                else:
                    temp = 0
                    while stack:
                        if stack[-1] == '(':
                            stack[-1] = temp * 2
                            break
                        else:
                            temp += stack.pop()
            else:
                if stack[-1] == '[':
                    stack[-1] = 3
                else:
                    temp1 = 0
                    while stack:
                        if stack[-1] == '[':
                            stack[-1] = temp1 * 3
                            break
                        else:
                            temp1 += stack.pop()
    return sum(stack)


gwalho = [i for i in sys.stdin.readline().rstrip()]
if check():
    print(cal())
else:
    print(0)
