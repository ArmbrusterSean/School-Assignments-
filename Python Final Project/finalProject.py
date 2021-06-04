# Sean Armbruster
# CSC 121 400 SP20
# Final Project

# A local school has asked you to create an application that grades multiple choice exams.
# You are given a set of files. One file is called "Key", it contains the correct answers.


def main():

    # open the Student file and the key file & read them as lists 
    with open('key.txt', 'r') as key:
        keyList = key.readlines()
        
    with open('student1.txt', 'r') as stu:
        stuList = stu.readlines()

    # calling the functions
    printName(stuList)
    noName(stuList,keyList)
    print(compFiles(keyList,stuList),'%')

# printing the first element as name
def printName(stuList):
    print('Student:',stuList[0])

# removing the first element 
def noName(stuList,keyList):
    del stuList[0]
    del keyList[0]
    return stuList,keyList

# use list comprehension to iterate through the files
# and isolate the differences
def compFiles(keyList,stuList):
    compare = [ x for x in keyList if x not in stuList]
    wrong = len(compare)
    total = len(stuList)
    right = total - wrong

    percent = int(100 * (right/total))
    return percent 
            

main()


