# Space Invaders

Space Invaders is a classic arcade game where the player controls a spaceship and must fend off waves of alien invaders.

## Description

This project is a Java implementation of the Space Invaders game using JavaFX libraries for the user interface. The game features multiple levels with increasing difficulty, allowing players to maneuver their spaceship, shoot enemy invaders, and survive for as long as possible.

## Features

- Intuitive spaceship controls using keyboard input.
- Three levels of increasing difficulty, each with unique enemy formations.
- Randomized enemy shooting patterns to keep gameplay challenging.
- Responsive UI with real-time updates on remaining lives, current level, and elapsed time.
- Engaging sound effects to enhance the gaming experience.

## Installation

To run the Space Invaders game, ensure you have Java installed on your system. Then, follow these steps:

1. Clone this repository to your local machine.
2. Open the project in your preferred Java IDE.
3. Build the project and resolve any dependencies.
4. Run the `Main` class to start the game.

## Controls

- Use the **arrow keys** to move the spaceship (up, down, left, right).
- Press the **spacebar** to shoot missiles at enemy invaders.
- Press **N** to switch between different types of bullets.

## Screenshots

![Screenshot 1](https://private-user-images.githubusercontent.com/151680710/303860087-b2e5ba33-ee51-411c-96d0-35ff73f88e8d.png?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3MDc1OTI5MTYsIm5iZiI6MTcwNzU5MjYxNiwicGF0aCI6Ii8xNTE2ODA3MTAvMzAzODYwMDg3LWIyZTViYTMzLWVlNTEtNDExYy05NmQwLTM1ZmY3M2Y4OGU4ZC5wbmc_WC1BbXotQWxnb3JpdGhtPUFXUzQtSE1BQy1TSEEyNTYmWC1BbXotQ3JlZGVudGlhbD1BS0lBVkNPRFlMU0E1M1BRSzRaQSUyRjIwMjQwMjEwJTJGdXMtZWFzdC0xJTJGczMlMkZhd3M0X3JlcXVlc3QmWC1BbXotRGF0ZT0yMDI0MDIxMFQxOTE2NTZaJlgtQW16LUV4cGlyZXM9MzAwJlgtQW16LVNpZ25hdHVyZT04YmE5ZjhiNjNhMmM2ZWRiZDZiMzIzMmMyZGZlN2JhYjA1M2IyZWI3NjBmZWFkYjdjNmVmZmM2ZTU5Y2FiODdjJlgtQW16LVNpZ25lZEhlYWRlcnM9aG9zdCZhY3Rvcl9pZD0wJmtleV9pZD0wJnJlcG9faWQ9MCJ9.-7cEW1akfhDDP99XWlHlQru9jszZVspr1hHmDtfdZN0)
![Screenshot 2](https://private-user-images.githubusercontent.com/151680710/303860090-c50885ce-b8df-4ce5-a535-f68ba7eb1dde.png?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3MDc1OTI5MTYsIm5iZiI6MTcwNzU5MjYxNiwicGF0aCI6Ii8xNTE2ODA3MTAvMzAzODYwMDkwLWM1MDg4NWNlLWI4ZGYtNGNlNS1hNTM1LWY2OGJhN2ViMWRkZS5wbmc_WC1BbXotQWxnb3JpdGhtPUFXUzQtSE1BQy1TSEEyNTYmWC1BbXotQ3JlZGVudGlhbD1BS0lBVkNPRFlMU0E1M1BRSzRaQSUyRjIwMjQwMjEwJTJGdXMtZWFzdC0xJTJGczMlMkZhd3M0X3JlcXVlc3QmWC1BbXotRGF0ZT0yMDI0MDIxMFQxOTE2NTZaJlgtQW16LUV4cGlyZXM9MzAwJlgtQW16LVNpZ25hdHVyZT0zYjVmZWRiODEzMzU3YmUyOTFmNjM0OGUxNTU4MDc4NTY0YjVmZGFiNDYxZDIyYTRhNWQwMjQyZTc4N2E1ZDNkJlgtQW16LVNpZ25lZEhlYWRlcnM9aG9zdCZhY3Rvcl9pZD0wJmtleV9pZD0wJnJlcG9faWQ9MCJ9.sZ2ZxNRY4OLeq90wxAfswhPrBp7mMpf89f98lcY2vOU)
![Screenshot 3](https://private-user-images.githubusercontent.com/151680710/303860083-fbddc7e9-c647-4ea6-b57f-c62a087d9e38.png?jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbSIsImtleSI6ImtleTUiLCJleHAiOjE3MDc1OTI5MTYsIm5iZiI6MTcwNzU5MjYxNiwicGF0aCI6Ii8xNTE2ODA3MTAvMzAzODYwMDgzLWZiZGRjN2U5LWM2NDctNGVhNi1iNTdmLWM2MmEwODdkOWUzOC5wbmc_WC1BbXotQWxnb3JpdGhtPUFXUzQtSE1BQy1TSEEyNTYmWC1BbXotQ3JlZGVudGlhbD1BS0lBVkNPRFlMU0E1M1BRSzRaQSUyRjIwMjQwMjEwJTJGdXMtZWFzdC0xJTJGczMlMkZhd3M0X3JlcXVlc3QmWC1BbXotRGF0ZT0yMDI0MDIxMFQxOTE2NTZaJlgtQW16LUV4cGlyZXM9MzAwJlgtQW16LVNpZ25hdHVyZT0zNDVkZjgyNWE5M2NmZmVlM2RhZDU0ODM0MWJmNjkxMjcyNDQwNzcxOWM2N2RjZTQ2NmE0MGFkYzM5ZTlhYTVkJlgtQW16LVNpZ25lZEhlYWRlcnM9aG9zdCZhY3Rvcl9pZD0wJmtleV9pZD0wJnJlcG9faWQ9MCJ9.msocKAveqW2GDbeGaRcrrAnLO8pvmXgDyB585DEw8KY)


## Credits

This project was developed by Ryan Helou.
