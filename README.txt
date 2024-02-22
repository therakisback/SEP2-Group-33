Brief summary of the basic ideas developed for how the game would function

  For starters: The board is represented as a theoretical sequence of numbers

           (0,0) (0,1) (0,2) (0,3) (0,4)
        (1,0) (1,1) (1,2) (1,3) (1,4) (1,5)
     (2,0) (2,1) (2,2) (2,3) (2,4) (2,5) (2,6)
   (3,0) (3,1) (3,2) (3,3) (3,4) (3,5) (3,6) (3,7)
(4,0) (4,1) (4,2) (4,3) (4,4) (4,5) (4,6) (4,7) (4,8)
   (5,0) (5,1) (5,2) (5,3) (5,4) (5,5) (5,6) (5,7)
      (6,0) (6,1) (6,2) (6,3) (6,4) (6,5) (6,6)
         (7,0) (7,1) (7,2) (7,3) (7,4) (7,5)
            (8,0) (8,1) (8,2) (8,3) (8,4)

 Each outside face of the hexagons will be labeled with a number as well

            1 /   \ 2
  (0, 0) = 0 |     | < next hex
   next hex > \   /  < next hex

Which is useful later with rays. Speaking of:
Rays are much more like a particle to us, think of it as light
   it's both particle and beam.
Ex: Ray r = new Ray(0, 0, 3, 3); has the following details:
   First: the first two numbers 0 are the location, marking the ray started
      in hex (0,0). Imagine the ray as a little particle floating in that hex
   Secondly: The first 3 is the direction of the ray, it marks like
      marking the starting point of a 1x1 board, as the rays go *away* from
      the sides: (this is also what makes it appear as a ray once the algorithm is finished)

           1 /   \ 2
          0 |  *  | 3
           5 \   / 4

      In this case, the ray is going left, from side 3 to side 0.
   Lastly; The final number, the second 3, is the starting side of the ray,
      this just makes it easier to keep track of where to put the result
      of the ray.

As for how rays handle atoms:

After the computer generates where the atoms are going to be (non-repeating number 0-60 inclusive)
   the atoms are stored in an array, with their location hopefully easily accessible

When the rays "tick" and move, they can check the locations of the atoms to see whether its inside 
   the 6 hexes near the ray, meaning all the computer is doing is comparing the 6 hexagons
   near the ray against the 4 atoms

As a note for making constructors: 
  values for grid spaces must be between: 	0-60 inclusive
  values for direction must be between: 	0-5  inclusive
  values for board sides must be between:	0-53 inclusive

For rays results follow this pattern:

result = -2      : ray was returned to start
result = -1      : ray was absorbed
result = [0..53] : ray ended at side [0..53]