# Terminal Game: Minesweeper

A text-based game of Minesweeper.

## Overview

This is a text-based version of Minesweeper built to run in the terminal. I created this small project as the start of an online student portfolio. 2D arrays, for and while loops, if-else clauses, switch statements, use of static methods, and user input are highlighted in this project.

## Dependencies/Installation Requirements

This game is meant to be run in the terminal (instructions to follow).

You will need Java installed on your computer in order to run the game. 
Make sure you have **Java Version 22.0.2**
You can safely download versions of Java here: **https://www.oracle.com/java/technologies/downloads/**

## Installing and Running the Game

The simplest way to install this project is to clone the repository as follows in your terminal:

### Cloning the repository:
```git clone https://github.com/username/projectname.git```

### Navigating to the folder location:
```cd projectname```

### Compiling the game:
```javac Minesweeper.java```

### Running the game:
```java Minesweeper```

# How to Play

For those unfamiliar with the rules of Minesweeper, here's a quick rundown:

-Your goal is to capture the flag!

-In each turn, you will be presented with the current minefield (represented by a 5x5 grid), and then prompted to enter the row letter and then the column number that corresponds to the space you wish to select to see if the flag is there. 
For example, to search the very bottom-right space, you would type ```E``` or ```e```, and then ```5```. Be sure to hit ```enter``` after each input.

-Once your input is processed, the minefield will be reprinted and you will see either an ```F``` for "Flag", ```X``` for a bomb, or a single-digit number appear in the space you selected. 

-A number represents how many bombs are adjacent to the space itself, including diagonally adjacent spaces. For example, seeing ```8``` appear on a space means that the space is completely surrounded by bombs in all 8 adjacent spaces.

-**You only have 3 lives**, so be careful about which spaces you select!

-Once you hit three bombs, it's GAME OVER. But if you find the flag before then, you WIN!
