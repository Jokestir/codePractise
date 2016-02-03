import os
import glob

#path = os.path.dirname(os.path.abspath(__file__))                                      # current path of the script
duplicates = 0
iterations = 0
def removeProductDuplicateStringsFromFile(fileName):
    global duplicates
    global iterations
    
    iterations = iterations + 1
    
    print (str(iterations))
    filename = open(fileName,mode = 'r+', encoding = 'utf-8')
    path = os.path.dirname(fileName) 
    newTempFileName = os.path.join(path,"temp.xml")
    newfile = open(newTempFileName,mode = 'w+', encoding = 'utf-8')
    
    for line in filename:
        
        if ("product" in line) and ("tablet" in line or "nosdcard" in line):
            duplicates = duplicates + 1
            continue
        else:
            newfile.write(line)
            
    filename.close()
    newfile.close()
    os.remove(fileName)
    os.rename(newTempFileName,fileName)


for filename in glob.iglob('src/**/*.xml', recursive=True):                          # recursively open xml files in the src folder
    removeProductDuplicateStringsFromFile(filename)

print(str(duplicates) + " strings removed ")

    
