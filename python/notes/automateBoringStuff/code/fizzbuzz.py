number = int(input('Enter a number: '))


if (number%15) == 0:
    print('Multiple of 15')
elif (number%5) == 0:
    print('Multiple of 5')
elif (number%3) == 0:
    print('Multiple of 3')
else:
    print('Neither a multiple of 5 nor 3')
