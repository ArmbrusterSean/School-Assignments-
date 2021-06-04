# messing around twith the formula


def main():

    # array for student files 
    students = []

    # open the key file and read it 
    with open('key.txt', 'r') as key:
        keyList = key.readlines()
        
    # Open the student .txt files and append them in the array students     
    with open('student1.txt', 'r') as stu:
        stuList = stu.readlines()
        students.append(stuList)
    with open('student2.txt', 'r') as stu:
        stuList = stu.readlines()
        students.append(stuList)
    with open('student3.txt', 'r') as stu:
        stuList = stu.readlines()
        students.append(stuList)
    with open('student4.txt', 'r') as stu:
        stuList = stu.readlines()
        students.append(stuList)
    with open('student5.txt', 'r') as stu:
        stuList = stu.readlines()
        students.append(stuList)

    print(students[0])

    # output each student grade
    print('Student Name:',printName(students[0]) + 'Test Score: ',compFiles(keyList,students[0]),'%' ,'\n')
    print('Student Name:',printName(students[1]) + 'Test Score: ',compFiles(keyList,students[1]),'%','\n')
    print('Student Name:',printName(students[2]) + 'Test Score: ',compFiles(keyList,students[2]),'%','\n')
    print('Student Name:',printName(students[3]) + 'Test Score: ',compFiles(keyList,students[3]),'%','\n')
    print('Student Name:',printName(students[4]) + 'Test Score: ',compFiles(keyList,students[4]),'%','\n')

# print the first element as name
def printName(name):
    return name[0]


# This function deltes the first element, iterates through the lists and compares the students array to the key.txt
# as well as calculating the percentage of the test scores.
def compFiles(keyList,stuList):
    #delete the [0] of each element in the students array
    del stuList[0]
    del keyList[0]
    # iterate using list comprehension to find the missed answers 
    compare = [ x for x in keyList if x not in stuList]
    #figure the length of the tests to the key and count the # of right and wrong answers
    wrong = len(compare)
    total = len(stuList)
    right = total - wrong
    # find the percentage and return the value 
    percent = int(100 * (right/total))
    
    return percent 
            

main()
