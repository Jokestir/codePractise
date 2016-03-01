storedPassword = 'storageapis'


enteredPassword = input('Enter the password: ')


if enteredPassword == storedPassword:
    print('Access granted')
else:
    print ('Wrong password!')
