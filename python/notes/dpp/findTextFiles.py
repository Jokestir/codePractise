import os

path = 'C:\\Users\\chirag.ahuja\\Desktop\\settingsAPK' 

# use os.walk()

for (root, dirs, files) in os.walk(path):
	for file in files:
		if ((os.path.splitext(file))[1] == '.txt'):
			print(os.path.join(root,file))

input("End of program")
