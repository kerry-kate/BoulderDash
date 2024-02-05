package view;

import contract.IMap;
import contract.IMobile;
import model.allElements.Element;
import model.allElements.mobileElem.Player;
import model.allElements.staticElem.Rock;
import model.allElements.staticElem.Wall;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;


import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


public class BoulderDashViewTest {

    private IMap map;
    private IMobile player;
    private BoulderDashView view;

    @BeforeEach
    public void setup() throws InterruptedException {

        map = new mock();
        player = new mock();
        view = new BoulderDashView(map);
        view.setPlayer(player);

    }

    @Test
    public void testGetPlayer() {
        IMobile Player = view.getPlayer();
        Assertions.assertNotNull(Player);
        Assertions.assertEquals(player, Player);
    }

    @Test
    public void testGetMap() {
        IMap Map = view.getMap();
        Assertions.assertNotNull(Map);
        Assertions.assertEquals(map, Map);
    }

    @Test
    void testHandleKeyTyped() {
        JLabel[][] labels = new JLabel[40][22];
        ImageIcon playerIcon = new ImageIcon();
        JLabel playerLabel = new JLabel(playerIcon);
        labels[10][10] = playerLabel; //(position initial) // on a des valeurs quelconques pour les positions qu'on va remplacer
        view.setLabels(labels);
        player.setPosition(new Point(10, 10));
        KeyEvent eventA = new KeyEvent(new JLabel(), KeyEvent.KEY_TYPED, System.currentTimeMillis(), 0, KeyEvent.VK_UNDEFINED, 'E');
        view.keyTyped(eventA);
        KeyEvent eventW = new KeyEvent(new JLabel(), KeyEvent.KEY_TYPED, System.currentTimeMillis(), 0, KeyEvent.VK_UNDEFINED, 'Q');
        view.keyTyped(eventW);
        KeyEvent eventS = new KeyEvent(new JLabel(), KeyEvent.KEY_TYPED, System.currentTimeMillis(), 0, KeyEvent.VK_UNDEFINED, 'Q');
        view.keyTyped(eventS);
        KeyEvent eventD = new KeyEvent(new JLabel(), KeyEvent.KEY_TYPED, System.currentTimeMillis(), 0, KeyEvent.VK_UNDEFINED, 'Q');
        view.keyTyped(eventD);
    }

    @Test
    void testHandleKeyReleased() {
        JLabel[][] labels = new JLabel[40][22];
        ImageIcon playerIcon = new ImageIcon();
        JLabel playerLabel = new JLabel(playerIcon);
        labels[10][10] = playerLabel;
        view.setLabels(labels);
        player.setPosition(new Point(10, 10)); //(position initial) // on a des valeurs quelconques pour les positions qu'on va remplacer
        KeyEvent eventW = new KeyEvent(new JLabel(), KeyEvent.KEY_RELEASED, System.currentTimeMillis(), 0, KeyEvent.VK_W, 'W');
        view.keyReleased(eventW);
        KeyEvent eventS = new KeyEvent(new JLabel(), KeyEvent.KEY_RELEASED, System.currentTimeMillis(), 0, KeyEvent.VK_S, 'S');
        view.keyReleased(eventS);
        KeyEvent eventA = new KeyEvent(new JLabel(), KeyEvent.KEY_RELEASED, System.currentTimeMillis(), 0, KeyEvent.VK_A, 'A');
        view.keyReleased(eventA);
        KeyEvent eventD = new KeyEvent(new JLabel(), KeyEvent.KEY_RELEASED, System.currentTimeMillis(), 0, KeyEvent.VK_D, 'D');
        view.keyReleased(eventD);

    }

    @Test
    void testHandleKeyPressed() {
        JLabel[][] labels = new JLabel[40][22];
        ImageIcon playerIcon = new ImageIcon();
        JLabel playerLabel = new JLabel(playerIcon);
        labels[10][10] = playerLabel;
        view.setLabels(labels);
        player.setPosition(new Point(10, 10));//(position initial) // on a des valeurs quelconques pour les positions qu'on va remplacer
        KeyEvent eventW = new KeyEvent(new JLabel(), KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_W, 'W');
        view.keyPressed(eventW);
        player.setPosition(new Point(10, 9));
        KeyEvent eventS = new KeyEvent(new JLabel(), KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_S, 'S');
        view.keyPressed(eventS);
        player.setPosition(new Point(10, 11));
        KeyEvent eventA = new KeyEvent(new JLabel(), KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_A, 'A');
        view.keyPressed(eventA);
        player.setPosition(new Point(9, 10));
        KeyEvent eventD = new KeyEvent(new JLabel(), KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_D, 'D');
        view.keyPressed(eventD);
        player.setPosition(new Point(11, 10));

    }
}

