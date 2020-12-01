advent_array = []

with open("1_1.txt") as advent_input: 
    for line in advent_input:
        advent_array.append(int(line.removesuffix('\n')))

def find_number(array):
    for i in advent_array:
        for y in advent_array: 
            if i + y == 2020:
                print("First number: " + str(i))
                print("Second number: " + str(y))
                print("Numbers added together: " + str(i+y))
                print("Numbers multiplied:")
                return i*y

def find_number_three(array):
    for i in advent_array: 
        for y in advent_array: 
            for z in advent_array:
                if i + y + z == 2020:
                    return i*y*z 
#Problem 1
print(find_number(advent_array))

#Problem 2
print(find_number_three(advent_array))
