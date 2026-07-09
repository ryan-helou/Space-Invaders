# Space Invaders

*A JavaFX take on the arcade shooter, built for a programming course at Vanier College.*

You pilot a ship across the bottom of a 1000×1000 window and try to clear three waves of invaders before they wear down your three lives. Each level raises both the crowd and the danger: 15 enemies in a 3×5 grid, then 21 in a 3×7, then 28 in a 4×7, with per-enemy fire probability climbing from 0.5 to 0.8 to 1.0. Your own weapon widens to match — a single upward missile on level 1, angled left-and-right shots on level 2, all three at once on level 3.

The invaders hold their formation and drop bullets straight down rather than marching sideways, so the game is really about dodging while you thin the ranks. Collisions are JavaFX bounding-box overlaps (`getBoundsInParent().intersects`) tested every frame by an `AnimationTimer`, which also moves the bullets, spawns explosion GIFs, and refreshes the lives and elapsed-time labels. One `Sprite` class extending `Rectangle` backs every ship, invader, missile, and blast.

Controls:
- WASD to move the ship
- Space to fire
- N to cycle among three missile skins

Built with Java, JavaFX, and Gradle, with sound effects and arcade fonts thrown in.

<img width="995" alt="sc2" src="https://github.com/user-attachments/assets/4e34ffa5-8e25-4d68-8f5f-35c443b6af90">
<img width="994" alt="sc1" src="https://github.com/user-attachments/assets/eb9daad3-1392-463e-a387-e21f0e32ecc7">
