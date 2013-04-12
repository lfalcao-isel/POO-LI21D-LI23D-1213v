package poo.cryptraider.levels;

import poo.cryptraider.Board;
import poo.cryptraider.CryptRaider;
import poo.cryptraider.actors.Actor;

public class Level1 extends Level {

	@Override
	public Board getBoard(CryptRaider game) {
		String levelStr[] =  new String[] {
			"##################", 
			"#    $#          #",
			"#    $# ***A**** #", 
			"#    $# ******** #", 
			"# C  $#          #",
			"#$$$ $# #### ### #", 
			"#### ##    #P#   #", 
			"#  # #     ###   #",
			"#                #", 
			"#$$$$$$$$$$$$$$$$#", 
			"#****************#",
			"##################"
		};
		
		return getBoard(levelStr, game);
	}
}
