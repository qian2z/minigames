import random

def get_word():
    # computer randomly choose a word that is going to be guessed from the word list
    word_list = ['red', 'orange', 'yellow', 'green', 'blue', 'indigo', 'purple']
    word = random.choice(word_list)
    return word.upper()

def play(word):

    # initialize variables
    word_completion = "_" * len(word)
    guessed = False
    guessed_letters = []
    tries = 6

    # first printing
    print("Let's play Hangman!")
    print(display_hangman(tries))
    print("Your word (", len(word), "letters ):", word_completion)
    print("\n")

    # loop
    while not guessed and tries > 0:

        # get player's guess
        guess = input("Please guess a letter: ").upper()

        # check the input guess whether is an alphabet letter
        # len(guess) is the length of the input guess.
        # isalpha() to check whether the input guess contains alphabet only.
        if len(guess) == 1 and guess.isalpha():

            # if the input guess is already guessed
            if guess in guessed_letters:
                print("You already guessed the letter", (guess + ". Please try again."))

            # if the input guess is wrong, is not in the WORD
            elif guess not in word:
                print(guess, "is not in the word.")
                # deduct the tries by one
                tries -= 1
                # add the guessed letter to the guessed_letters list
                guessed_letters.append(guess)

            # if the input guess is correct, is in the WORD
            else:
                print("Good job,", guess, "is in the word!")
                # add the guessed letter to the guessed_letters list
                guessed_letters.append(guess)
                # replace the respective unknown symbol with the correct letter
                word_as_list = list(word_completion)
                indices = [i for i, letter in enumerate(word) if letter == guess]
                for index in indices:
                    word_as_list[index] = guess
                word_completion = "".join(word_as_list)

                # check if there is still have any unknown symbol in the guessing WORD
                if "_" not in word_completion:
                    guessed = True

        elif len(guess) == len(word) and guess.isalpha():
            if guess in guessed_letters:
                print("You already guessed the word", (guess + "."))
            elif guess != word:
                print(guess, "is not the word.")
                tries -= 1
                guessed_letters.append(guess)
            else:
                guessed = True
                word_completion = word

        # if the input guess is not an alphabet letter or the input guess is not a valid word guess
        else:
            print("Not a valid guess. Please try again.")

        # print current state of the hangman and the progress of the guessing WORD
        print(display_hangman(tries))
        print("Your word (", len(word), "letters ):", word_completion)
        print("\n")

    # final result
    # if the WORD is guessed correctly
    if guessed:
        print("Congratulations, you guessed the word! You win!")
    # if the player has run out of tries
    else:
        print("Sorry, you ran out of tries. The word was " + word + ". Maybe next time!")


def display_hangman(tries):
    stages = [  # final state: head, torso, both arms, and both legs
                """
                   --------
                   |      |
                   |      O
                   |     \\|/
                   |      |
                   |     / \\
                   -
                """,
                # head, torso, both arms, and one leg
                """
                   --------
                   |      |
                   |      O
                   |     \\|/
                   |      |
                   |     / 
                   -
                """,
                # head, torso, and both arms
                """
                   --------
                   |      |
                   |      O
                   |     \\|/
                   |      |
                   |      
                   -
                """,
                # head, torso, and one arm
                """
                   --------
                   |      |
                   |      O
                   |     \\|
                   |      |
                   |     
                   -
                """,
                # head and torso
                """
                   --------
                   |      |
                   |      O
                   |      |
                   |      |
                   |     
                   -
                """,
                # head
                """
                   --------
                   |      |
                   |      O
                   |    
                   |      
                   |     
                   -
                """,
                # initial empty state
                """
                   --------
                   |      |
                   |      
                   |    
                   |      
                   |     
                   -
                """
    ]
    return stages[tries]

def main():
    word = get_word()
    play(word)
    while input("Play Again? (Y/N) ").upper() == "Y":
        word = get_word()
        play(word)

main()