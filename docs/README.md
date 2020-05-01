# LPOO_T5G2 - Cubefield
Our game is inspired by Cubefield. Cubefield is an endless runner game where the players' reactions are tested in order to avoid colliding with fast moving blocks.

## Features
### So far:
- Movement - the character moves horizontally according to input
- Movement - the character has *weight* due to acceleration and drag implementation
- Gameplay - cubes fall with adjustable speed
- Score - score is kept track in real-time and displayed in an overaly
### Planned:
- **game levels** with increasing difficulty 
- game difficulty increases by **increasing speed** with which the obstacles move
- obstacle patterns to represent **level transition**
- certain **key combinations** allow our player to use some extra *powers* against the obstacles
- the player can also get some extra powers by **hitting _certain_ obstacles**

## Design
### Problem in Context
There was a considerable amount of too tightly coupled code, accompanied by classes with too much responsibility. The lack of modularity caused both difficulty extending functionality and unit testing the code.
### The pattern
We applied the **MVC** architectural pattern. This pattern allows for **separation of concerns** while simultaneously promoting **looser coupling**. This pattern addresses the identified problems because it implies the division of the program logic into three loosely coupled units. That promotes both modularity and the usage of single-responsibility principle.
### Implementation
The game was separated in three units: the model (representing the data), the view (representing the interface with the user, both visuals and inputs) and the controller (representing the rules and core logic of the game).

The **model** part aggregates classes that provide data for game entities such as the **player**, the **cubes** and the **arena** where they exist. The **view** classes are responsible for knowing how each entity is drawn, and the controllers' are responsible for the main loop and entity behavior. 
### Consequences
The use of MVC provided the following advantages:
* Due to the looser coupling, dependency injection was possible allowing proper unit testing to happen.
* The separation in logical units allowed for less bloated classes.
* It became easier to replace a given part of the program for a different implementation.
---
### Problem in context
At first the game behaved like a turn-based game, advancing on user input. New features were added that related to each other through time and that needed to happen whether or not there was player input.
### The pattern
We applied the **game loop** pattern. The pattern defines an (well, almost) infinite loop where three stages are executed in sequence. First the user input is captured, then the game's internal state is updated, and finally the result is rendered to the screen. Different variations of the game loop pattern also allow to set a target frame rate with various degrees of robustness.
### Implementation
Due to following the MVC pattern described above, most of the structure in order to implement the game loop was already there. We start by capturing user input using the ArenaView class for the first stage. Then we execute all the *controller* classes so to update the game state. Finally, the scene is rendered by, once again, the ArenaView class. We chose to implement a simple sleep mechanism that waits the remaining time of each frame time.
### Consequences
The game loop pattern provided the following advantages:
* The game no longer spins needlessly.
* There is a fixed (yet adjustable) frame time, which can be used as a reference for the passage of time.

Still, there are some things to keep in mind:
* The frame time must be set conservatively as *most* computers can not go back in time (at least not mine). Our implementation does not account for situations where the game goes over budget.
* Time based events are effectively bound to the frame rate, providing less flexibility.
## Known code smells

## Refactoring:

## Tests:
