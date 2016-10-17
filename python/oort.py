import os

# searches for source files in the present working directory
script_path = os.getcwd()

# md files path

md_files_folder = 'source'

# destination path

destination_path_folder = 'docs'


# md pages list

md_page_list = None

def getMdFilePath():
    return os.path.join(script_path,md_files_folder)




# TODO add lunr.js search

def populateMdPages():
    global md_page_list
    md_page_list = [ f for f in os.listdir(getMdFilePath()) if os.path.isfile(os.path.join(getMdFilePath(),f))]

	
def convertToHtml():

	
populateMdPages()

    
    
        
