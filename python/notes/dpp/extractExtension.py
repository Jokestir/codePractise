import os

# lists separates teh file name and the extension

print('')
list = os.path.splitext((os.path.abspath(__file__)))
print(list)
input("press enter to exit ")