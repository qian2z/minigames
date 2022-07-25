import random

rock = '\U0001faa8' + "(Rock)"
paper = '\U0001f4c3' + "(Paper)"
scissors = '\u2702' + "(Scissors)"

def play():

    # get user's input
    user = input("What is your choice? \n'R' for " + rock + ", 'P' for " + paper + ", 'S' for " + scissors + "\n>> ")
    # convert user's input to uppercase
    user = user.upper()

    # get computer's choice
    choice_list = ['R', 'P', 'S']
    computer = random.choice(choice_list)

    # logic statement
    # if both inputs are the same, it is a tie
    if user == computer:
        print('It is a tie. You and the computer have both chosen', return_word(user), '.')

    # if both inputs are different, check whether the user beats the computer
    else:
        # winning conditions: R > S, S > P, P > R
        if (user == 'R' and computer == 'S') or (user == 'S' and computer == 'P') or (user == 'P' and computer == 'R'):
          # print user's win statement
          print('You chose', return_word(user), 'and the computer chose', return_word(computer), '.\nYou won!')
        # losing conditions: other than winning conditions
        else:
          # print user's lose statement
          print('You chose', return_word(user), 'and the computer chose', return_word(computer), '.\nYou lose :(')

def return_word(choice):
    if choice == 'R':
        return rock
    elif choice == 'P':
        return paper
    elif choice == 'S':
        return scissors

play()
while input("Play Again? (Y/N) ").upper() == "Y":
    play()