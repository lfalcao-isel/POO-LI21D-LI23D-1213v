package poo.cryptraider.test;

import junit.framework.Assert;

import org.junit.Test;

import poo.cryptraider.CryptRaider;
import poo.cryptraider.Point;
import poo.cryptraider.actors.Actor;
import poo.cryptraider.actors.Artifact;
import poo.cryptraider.actors.Carter;

public class TestLevels {

	//@Test
	public void shouldMovecarterAndArtifact() {
		// Arrange
		CryptRaider c = new CryptRaider();
		c.loadLevel(new RaiderArtifaColisionLevel());
		
		
		// Act
		c.moveActors('d');
		
		
		// Assert
		Point pos = new Point(1,3);
		Actor carter = c.getActor(pos);
		
		Assert.assertTrue(carter instanceof Carter);
		Assert.assertEquals(pos, carter.getPosition());
		
		pos = new Point(1,4);
		Actor artifact = c.getActor(pos);
		Assert.assertTrue(artifact instanceof Artifact);
		Assert.assertEquals(pos, artifact.getPosition());
	}

	
	//void shouldLoad
	
}
