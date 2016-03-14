# Q. given a number num, find out whether its prime

import math

def isPrime(num):
	# wilsons theorem
	return (((math.factorial(num-1)) % num) == (num-1))


num = input("Enter an integer: ")

if isPrime(num):
	print("Prime number")
else:
	print("Not prime")
	