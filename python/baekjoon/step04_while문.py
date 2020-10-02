import sys

# P10952 A+B - 5
while True:
    A, B = map(int, sys.stdin.readline().rstrip().split(' '))

    if A == 0 and B == 0:
        break

    print(A+B)


# P10951 A+B - 4
while True:
    try:
        A, B = map(int, sys.stdin.readline().rstrip().split(' '))
        print(A + B)

    except:
        break


# P1110 더하기 사이클
N = int(sys.stdin.readline().rstrip())

cnt = N == 0 and 1 or 0
new_n = 0
cpy_n = N
while new_n != N:
    cnt += 1

    new_n = ((cpy_n % 10) * 10) + (((cpy_n // 10) + (cpy_n % 10)) % 10)
    cpy_n = new_n

print(cnt)