package io.github.ajmuzika.rpgplugin.commands;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class RollTest {
    @Test
    public void rollDice () {
        Roll roll = new Roll();
        int mynum = Integer.parseInt(roll.rollDice(20, 10));

        assertTrue("Roll is below minimum.",  10  <= mynum);
        assertTrue("Roll is above maximum.", 20 >= mynum);
    }
}
