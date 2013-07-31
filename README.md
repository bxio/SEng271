SEng271
=======

SEng271 A01 Summer 2013 Project Group.

## Specifications ##
Please see `Project.pdf` for Specification of the project.

## Running the Game ##
Run ``

## Writeups ##
The Writeups for the milestones and the source file for the diagram is on Google Docs.

Group members:
=======
* Greg Richardson
* Bill Xiong
* Alastair Fehr
* Hiroki Yun

To-Do
=======
## Bug Fixes ##
* Pawn and squares don't stop flashing when you select multiple pawns before making move.
* Pawn goes all the way around the board without stopping. [Bill & Greg working on fix, To duplicate, make a player's pawn land on another one of the same player's pawns]
* Pawn jumps from random square to home for no apparent reason [Bill, Greg working to replicate bug]
* Pawn seems to "not exist" occasionally, other pawns land on top of it without kicking it. [canMove method may be broken]
* When you drag on the window, Ludo throws UnsupportedOperationException (probably don't have time to fix this one)

## Programmatic ##
Finish implementing strategies
Implement path and path segments for each player
Figure out to instantiate with minimal overhead.

## Someday ##
Add multiplayer support over sockets
Add histogram to game over screen to show die results