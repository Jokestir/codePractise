

for i in range(10,20):
    flag = True
    for num in range(2,i-1):
        if i%num == 0:
            flag = False
            break
    if flag:
        print(str(i) + " is a prime number")
    
    i= i + 1
