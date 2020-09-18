# P2557 Hello World
print("Hello World!")


# P10718 We love kriii
print("강한친구 대한육군\n강한친구 대한육군")


# P10171 고양이
print("\    /\\")
print(" )  ( ')")
print("(  /  )")
print(" \(__)|")


# P10172 개
print("|\_/|")
print("|q p|   /}")
print("( 0 )\"\"\"\\")
print("|\"^\"`    |")
print("||_/=\\\__|")


# P1000 A+B
A, B = input().split()
print(int(A)+int(B))


# P1001 A-B
A, B = input().split()
print(int(A)-int(B))


# P10998 AXB
A, B = input().split()
print(int(A)*int(B))


# P1008 A/B
A, B = input().split()
print(int(A)/int(B))


# P10869 사칙연산
A, B = input().split()
A, B = int(A), int(B)
print(A+B)
print(A-B)
print(A*B)
print(int(A/B))
print(A%B)


# P10430 나머지
A, B, C = input().split()
A, B, C = int(A), int(B), int(C)
print((A+B)%C)
print(((A%C)+(B%C))%C)
print((A*B)%C)
print(((A%C)*(B%C))%C)


# P2588 곱셈
A = int(input())
B = int(input())

B1, B2, B3 = int(B%10), int((B/10)%10), int(B/100)
C1, C2, C3 = A*B1, A*B2, A*B3

print(C1)
print(C2)
print(C3)
print(A*B)