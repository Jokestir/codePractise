import os
import glob

#path = os.path.dirname(os.path.abspath(__file__))                                   


duplicates = 0																			# keep count of duplicate string removed


#iterations = 0                                                                          


def removeProductDuplicateStringsFromFile(fileName):                                    # function to remove duplicates from fileName
    
	global duplicates																	# duplicates is global not local
    
	#global iterations
    
    #iterations = iterations + 1
    
    #print (str(iterations))
	
    filename = open(fileName,mode = 'r+', encoding = 'utf-8')							# open file passed for editing
    path = os.path.dirname(fileName) 													# path of file passed
    newTempFileName = os.path.join(path,"temp.xml")                                     # create a temp file at the same location as file passed
    newfile = open(newTempFileName,mode = 'w+', encoding = 'utf-8')                     # open temp file for editing
    
    for line in filename:																# iterate each line of file passed
        
        if ("product" in line) and ("tablet" in line or "nosdcard" in line):			# if the line contains table and product or nosdcard, discard the line 
            duplicates = duplicates + 1
            continue
        else:
            newfile.write(line)															# else copy the line to temp file
            
    filename.close()																	# close the file passed
    newfile.close()																		# close temp file
    os.remove(fileName)																	# delete file passed from the machine
    os.rename(newTempFileName,fileName)													# rename temp file to file passed


for filename in glob.iglob('src/**/*.xml', recursive=True):                          	# recursively open xml files in the src folder
    removeProductDuplicateStringsFromFile(filename)										# remove duplicate strings

print(str(duplicates) + " strings removed ")											# print duplicates removed

    
