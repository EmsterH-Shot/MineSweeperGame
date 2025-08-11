# Terminal Game: Minesweeper

A text-based game of Minesweeper.

## Overview

This is a text-based version of Minesweeper built to run in the terminal. I created this small project to as the start of an online portfolio to demonstrate the Java programming skills I have learned so far in my university studies as a Computer Science major. 2D arrays, for and while loops, if-else clauses, switch statements, use of static methods, and user input are highlighted in this project.

## Dependencies/Installation Requirements

This game is meant to be run in the terminal (instructions to follow).

You will need Java installed on your computer in order to run the game. 
This file was created using **Java Version 22.0.2**, so it is recomended that you have that version or higher installed before running. 
You can safely download versions of Java here: **https://www.oracle.com/java/technologies/downloads/**

## Installing the Game

The simplest way to insall this project is to clone the repository as follows in your terminal:

'''
# Cloning the repository:
git clone https://github.com/username/projectname.git

# Navigating to the folder location:
cd projectname

# Compiling the game:

javac Minesweeper.java

# Running the game:

java Minesweeper
'''

# How to Play

For those unfamiliar with the rules of Minesweeper, here's a quick rundown:

-Your goal is to capture the flag! There is only one in the minefield you are searching, which, in this case, is a 5x5 grid.

-In this terminal-based version of the game, you will be prompted to enter the row letter and then the column number that corresponds to the space you wish to select to see if the flag is there. 
For example, to search the very bottom-right space, you would type '''E''' or '''e''', and then '''5'''. Be sure to hit '''enter''' after each input.

-Once your input is processed, the minefield will be reprinted and you will see either an '''F''' for 'Flag', '''X''' for a bomb, or a single-digit number appear in the space you selected. 

-A number represents how many bombs are adjacent to the space itself, including diagonally adjacent spaces. For example, seeing '''8''' appear on a space means that the space is completely surrounded by bombs in all 8 grid directions.

-**You only have 3 lives**, so be careful about which spaces you select! Use the numbers that appear on the grid to help you guess where a bomb might be.

-Once you hit three bombs, it's GAME OVER. But if you find the flag before then, you WIN!

# License

