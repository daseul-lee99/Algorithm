import sys

# P10818 최소, 최대
N = int(sys.stdin.readline())
arr = list(map(int, sys.stdin.readline().split()))
print(min(arr), max(arr))


# P2562 최댓값
arr = list(int(sys.stdin.readline()) for _ in range(9))
max_v = max(arr)
print("{}\n{}".format(max_v, arr.index(max_v)+1))


# P2577 숫자의 개수
a = int(sys.stdin.readline())
b = int(sys.stdin.readline())
c = int(sys.stdin.readline())

arr = list(str(a * b * c))
for i in range(10):
    print(arr.count(str(i)))


# P3052 나머지
arr = [int(sys.stdin.readline()) % 42 for _ in range(10)]
print(len(set(arr)))


# P1546 평균
N = int(sys.stdin.readline())
score = list(map(int, sys.stdin.readline().split()))

M = max(score)
score = [(s / M * 100) for s in score]
print(sum(score) / N)


# P8958 OX퀴즈
T = int(sys.stdin.readline())

for _ in range(T):
    ox = sys.stdin.readline().rstrip()

    total_score = 0
    cnt = 0
    for c in list(ox):
        if c == 'O':
            cnt += 1
            total_score += cnt
        else:
            cnt = 0
    print(total_score)


# P4344 평균은 넘겠지
C = int(sys.stdin.readline())

for _ in range(C):
    arr = list(map(int, sys.stdin.readline().split()))

    N = arr[0]
    score = arr[1:]
    avg = sum(score) / N

    cnt = 0
    for s in score:
        if s > avg:
            cnt += 1
    print("{:.3f}%".format(cnt / N * 100))