import os.path
import sys


def get_extension(filename):
    return os.path.splitext(filename)[1]


def get_file_name_without_extension(pathname):
    return os.path.basename(os.path.splitext(pathname)[0])


def srt_to_txt(filename):

    if not os.path.isfile(filename):
        print("enter a vaid file")
        print("program exiting...")
        sys.exit()

    if get_extension(filename) != ".srt":
        print("the extension of the file is not srt... Quiting the program...")
        sys.exit()

    with open(filename,"r") as f:
        txt_lines = f.readlines()

    for line in txt_lines:
        if "-->" in line:
            index = txt_lines.index(line)
            del txt_lines[index]
            del txt_lines[index-1]

    txt_file_name = os.path.basename(os.path.splitext(filename)[0]) + ".txt"

    with open(txt_file_name,"w+") as f:
        f.writelines(txt_lines)







