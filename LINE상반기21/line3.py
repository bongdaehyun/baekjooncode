from collections import deque


def solution(enter, leave):
    answer = dict()
    for i in enter:
        if i not in answer:
            answer[i] = set()
    people = []
    enter = deque(enter)
    leave = deque(leave)
    q = []
    while True:
        if not enter and not leave:
            break;
        if enter:
            q.append(enter.popleft())

            for i in range(len(q)):
                for j in range(len(q)):
                    answer[q[i]].add(q[j])

        while leave:
            if leave[0] in q:
                del q[q.index(leave[0])]
                leave.popleft()
            else:
                break

    for i in range(1, len(answer) + 1):
        people.append(len(answer[i]) - 1)
    return people