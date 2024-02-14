//import

/*
  Brief summary of the basic ideas developed for how the game would function

  For starters: The board is represented as a theoretical sequence of numbers

        0   1   2   3   4
      5   6   7   8   9   10
    11  12  13  14  15  16  17
  18  19  20  21  22  23  24  25
26  27  28  29  30  31  32  33  34
  35  36  37  38  39  40  41  42
    43  44  45  46  47  48  49
      50  51  52  53  54  55
        56  57  58  59  60

 Each outside face of the hexagons will be labeled with a number as well

            2 /   \ 3
  (0, 0) = 1 |     | < next hex
   next hex > \   /  < next hex
                ^ next hex

The numbering system works as a low-memory way to help the atoms remember where
   they are, and the atoms to look for them
Which is useful later with rays. Speaking of:
Rays are much more like a particle to us, think of it as em radiation
   it's both particle and beam.
Ex: Ray r = new Ray(0, 3, 3); has the following details:
   First: the first number 0 is the location, marking the ray started
      in hex 0. Imagine the ray as a little particle floating in that hex
   Secondly: The first 3 is the direction of the ray, it marks like
      marking the starting point of a 1x1 board, as the rays go *away* from
      the sides: (this is also what makes it appear as a ray once the algorithm is finished)

           2 /   \ 1
          3 |  *  | 6
           4 \   / 5

      In this case, the ray is going down and right, heading towards 6 from 3
   Lastly; The final number, the second 3, is the starting side of the ray,
      this just makes it easier to keep track of where to put the result
      of the ray.

As for how rays handle atoms, with the numbering system it's all essentially math

After the computer generates where the atoms are going to be (non-repeating number 0-60 inclusive)
   the atoms are stored in an array, with their location hopefully easily accessible




*/



/**
 * "Controller" class for the game, manages the functionality
 *    between the Game class running the game and the UI class
 *    dealing with user IO
 * <p>
 * A framework for this class and function is difficult,
 *    as it will rely on every other class
 */
public class Main {

    public static void main(String[] args) {
        // TODO
    }
}

