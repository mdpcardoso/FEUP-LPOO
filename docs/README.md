# LPOO_T5G2 - Cubefield
Our game is inspired by Cubefield. Cubefield is an endless runner game where the players' reactions are tested in order to avoid colliding with fast moving blocks.

## Features
### So far:
- Movement - the character moves horizontally according to input
- Movement - the character has *weight* due to acceleration and drag implementation
### Planned:
- **game levels** with increasing difficulty 
- game difficulty increases by **increasing speed** with which the obstacles move
- obstacle patterns to represent **level transition**
- keeping track of **score** in real time 
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
## Known code smells

## Refactoring:

## Tests:
