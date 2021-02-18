import sys

def check(): #올바른 괄호가 되는 지 판단
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

    if stack: #스택 안에 남아있으면 바람직하지 않은 괄호
        return False
    else: # 스택이 비어있으면 알맞은 괄호
        return True


def cal(): #알맞은 괄호 시 괄호 계산
    stack = []
    for c in gwalho:
        if c == '(' or c == '[': #열린 괄호시 스택에 저장
            stack.append(c)
        else:
            if c == ')': #닫힌 괄호를 만날때
                if stack[-1] == '(': #열린 괄호가 있다면 숫자 2저장
                    stack[-1] = 2
                else: #숫자를 만난다면 안쪽 괄호 계산
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


gwalho = [i for i in sys.stdin.readline().rstrip()] #괄호 입력
if check():
    print(cal())
else:
    print(0)
