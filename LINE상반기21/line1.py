def solution(table, languages, preference):
    answer = ''
    tables = []  # 직업군 언어점수
    for i in table:
        tables.append(i.split(","))

    # print(tables)#직업별로 리스트 생성
    # 개발자가 사용하는 언어 문자열배열 languages
    # 언어선호도 preference
    dev = dict()
    score = {1: 5, 2: 4, 3: 3, 4: 2, 5: 1}
    s = {0: 'SI', 1: 'CONTENTS', 2: 'HARDWARE', 3: 'PORTAL', 4: 'GAME'}
    for i in range(len(languages)):
        dev[languages[i]] = preference[i]
    result = []  # 0=> SI
    for t in tables:
        sum = 0
        t = t[0].split(" ")
        # print(t)
        for i in range(1, len(t)):
            if t[i] in dev:
                sum += dev[t[i]] * score[i]
        result.append(sum)
    # print(result)
    maxv = max(result)
    idx = []
    for i in range(5):
        if (maxv == result[i]):
            idx.append(s[i])
    idx.sort()
    answer = idx[0]
    return answer