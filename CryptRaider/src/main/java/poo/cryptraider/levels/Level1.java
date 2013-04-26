package poo.cryptraider.levels;

import poo.cryptraider.exceptions.LoadLevelException;


public class Level1 extends Level {

	@Override
	protected String[] getLevel() throws LoadLevelException {
		return new String[] {
			"##################", 
			"#    $#          #",
			"#    $#C?**A**** #", 
			"#    $# ******** #", 
			"#    $#          #",
			"#$$$ $# #### ### #", 
			"#### ##    #P#   #", 
			"#  # #     ###   #",
			"#                #", 
			"#$$$$$$$$$$$$$$$$#", 
			"#****************#",
			"##################"
		};
	}
}
