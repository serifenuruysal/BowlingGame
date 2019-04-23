# BowlingGame
Developed with MVP design pattern

Dependencies
minSdkVersion 19

Bowling is played by throwing a ball down a narrow alley
• Bowling is played by throwing a ball down a narrow alley toward ten wooden pins. The object is to knock down as many pins as possible per throw
• The game is played in ten frames. At the beginning of each frame, all ten pins are set up. The player then gets two tries to knock them all down.
• If the player knocks all the pins down on the first try, it is called a „strike,“ and the frame ends.
• If the player fails to knock down all the pins with his first ball, but succeeds with the second ball, it is called a „spare.“
• After the second ball of the frame, the frame ends even if there are still pins standing.
• A strike frame is scored by adding ten, plus the number of pins knocked down by the next two balls, to the score of the previous frame.
• A spare frame is scored by adding ten, plus the number of pins knocked down by the next ball, to the score of the previous frame.
• Otherwise, a frame is scored by adding the number of pins knocked down by the two balls in the frame to the score of the
previous frame.
• If a strike is thrown in the tenth frame, then the player may throw two more balls to complete the score of the strike.
• Likewise, if a spare is thrown in the tenth frame, the player may throw one more ball to complete the score of the spare.
• Thus the tenth frame may have three balls instead of two.

A typical game – Example
• The score card above shows a typical game.
• In the first frame, the player knocked down 1 pin with his first ball and four more with his second.
Thus, his score for the frame is five.
• In the second frame, the payer knocked down four pins with his first ball and five more with his second. That makes nine pins total, added to the previous frame makes fourteen.
• In the third frame, the player knocked down six pins with his first ball and knocked down the rest with his second for a spare. No score can be calculated for this frame until the next ball is rolled.
• In the fourth frame, the player knocked down five pins with his first ball. This lets us complete the scoring of the spare in frame three. The score for frame three is ten, plus the score in frame two (14), plus the first ball of frame four (5), or 29.
• The final ball of frame four is a spare.
• Frame five is a strike. This lets us finish the score of frame four which is 29 + 10 + 10 = 49
• Frame six is dismal. The first ball went in the gutter and failed to knock down any pins. The second ball knocked down only one pin. The score for the strike in frame five is 49 + 10 + 0 +1 = 60.
• The rest you can probably figure out for yourself.
