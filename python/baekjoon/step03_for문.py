import sys

# P2739 구구단
N = int(input())

for i in range(1, 10):
    print("%d * %d = %d" % (N, i, N * i))


# P10950 A+B - 3
T = int(input())

for i in range(T):
    A, B = map(int, input().split(' '))
    print(A + B)


# P8393 합
n = int(input())

res = 0
for i in range(1, n+1):
    res += i

print(res)


# P15552 빠른 A+B
T = int(sys.stdin.readline().rstrip())

for i in range(T):
    A, B = map(int, sys.stdin.readline().rstrip().split(' '))
    print(A + B)


# P2741 N 찍기
N = int(sys.stdin.readline().rstrip())

for i in range(1, N+1):
    print(i)


# P2742 기찍 N
N = int(sys.stdin.readline().rstrip())

for i in range(N, 0, -1):
    print(i)


# P11021 A+B - 7
T = int(sys.stdin.readline().rstrip())

for i in range(1, T+1):
    A, B = map(int, sys.stdin.readline().rstrip().split(' '))
    print("Case #%d: %d" % (i, A + B))


# P11022 A+B - 8
T = int(sys.stdin.readline().rstrip())

for i in range(1, T+1):
    A, B = map(int, sys.stdin.readline().rstrip().split(' '))
    print("Case #%d: %d + %d = %d" % (i, A, B, A + B))


# P2438 별 찍기 - 1
N = int(sys.stdin.readline().rstrip())

str = '*'
for i in range(N):
    print(str)
    str += '*'


# P2439 별 찍기 - 2
N = int(sys.stdin.readline().rstrip())

for i in range(N):
    str = ' ' * (N - (i + 1))
    str += '*' * (i + 1)
    print(str)


# P10871 X보다 작은 수
N, X = map(int, sys.stdin.readline().rstrip().split(' '))
A = list(map(str, sys.stdin.readline().rstrip().split(' ')))

str = ''
for i in A:
    if int(i) < X:
        str += i + ' '
print(str)