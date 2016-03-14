# Q. find out the extension of a filename.

import os

print('')
list = os.path.splitext((os.path.abspath(__file__)))
print(list[1])
input("press enter to exit ")
