# 1. open browser. (has to firefox 8) 2. open website. 3. authenticate if it asks. 4. read a field.
#5. wrtie to file. 6. close

# selenium documentation = http://selenium-python.readthedocs.io/locating-elements.html


from selenium import webdriver


firefox = webdriver.Firefox()

# step 1 end

firefox.get('https://example.com/')

# step 2 end.


element = firefox.find_element_by_tag_name('h1')

# step 4 end

with open('myfile.txt','w+') as f:
    f.write(element.text)

# step 5 end
f.close()

# end of step 6
