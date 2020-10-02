# P1330 두 수 비교하기
A, B = input().split(' ')
A, B = int(A), int(B)

if A > B:
    print('>')
elif A < B:
    print('<')
else:
    print('==')


# P9498 시험 성적
score = int(input())

if 90 <= score <= 100:
    print('A')
elif 80 <= score <= 89:
    print("B")
elif 70 <= score <= 79:
    print("C")
elif 60 <= score <= 69:
    print("D")
else:
    print("F")


# P2753 윤년
year = int(input())

if year % 4 == 0 and (year % 100 != 0 or year % 400 == 0):
    print(1)
else:
    print(0)


# P14681 사분면 고르기
x = int(input())
y = int(input())

if x > 0:
    if y > 0:
        print(1)
    else:
        print(4)
else:
    if y > 0:
        print(2)
    else:
        print(3)


# P2884 알람 시계
H, M = map(int, input().split(' '))

time = (H * 60) + M - 45

print("%d %d" % (time / 60 % 24, time % 60))