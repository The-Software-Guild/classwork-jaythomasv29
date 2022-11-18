package com.sg.testing.dao.implementations;

import com.sg.testing.dao.MonsterDao;
import com.sg.testing.dao.implementations.buggy.*;
import com.sg.testing.model.Monster;
import com.sg.testing.model.MonsterType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AGoodMonsterDaoTest {
    MonsterDao testDao;



    @BeforeEach
    void setUp() {
//        testDao = new AGoodMonsterDao();
//        testDao = new BadMonsterDaoA();  // Fixed bug in id field
//        testDao = new BadMonsterDaoB();  // Fixed bug in id field
//        testDao = new BadMonsterDaoC();  // Fixed bug in the removeMonster() dao method, getAllMonsters() is empty arraylist
//        testDao = new BadMonsterDaoE(); // No mistakes found
        testDao = new BadMonsterDaoF(); //
    }

    @Test
    void addMonster() {

        int monsterUuid = 001;
        String monsterName = "BigFoot";
        MonsterType mType = MonsterType.YETI;
        int totalEaten = 4;
        String favoriteFood = "Mountain people";
        Monster toBeAddedMonster = new Monster(monsterName, mType, totalEaten, favoriteFood);
        testDao.addMonster(monsterUuid, toBeAddedMonster);
        Monster addedMonster = testDao.getMonster(monsterUuid);
        assertEquals(toBeAddedMonster, addedMonster);

    }

    @Test
    void getMonster() {
        int monsterUuid = 001;
        String monsterName = "BigFoot";
        MonsterType mType = MonsterType.YETI;
        int totalEaten = 4;
        String favoriteFood = "Mountain people";
        testDao.addMonster(monsterUuid, new Monster(monsterName, mType, totalEaten, favoriteFood));
        Monster retrievedMonster = testDao.getMonster(monsterUuid);
        assertEquals(retrievedMonster, new Monster("BigFoot", MonsterType.YETI, 4, "Mountain people"));

    }

    @Test
    void getAllMonsters() {
        // create and add monster1 and monster2
        testDao.addMonster(002, new Monster("Medusa", MonsterType.SWAMPTHING, 100, "stone"));
        testDao.addMonster(003, new Monster("SwampMan", MonsterType.SWAMPTHING, 100, "sharks"));
        List<Monster> monsters = testDao.getAllMonsters();
        assertEquals(2, monsters.size(), "Monster list must contain 2 added elements inside");
        assertNotNull(monsters, "Monster list must not be null");
    }

    @Test
    void updateMonster() {
        // create a monster and add it
        Monster monster = testDao.addMonster(002, new Monster("Medusa", MonsterType.SWAMPTHING, 100, "stone"));
        testDao.updateMonster(002, new Monster("SirScaryMonster", MonsterType.SWAMPTHING, 55, "fishy people"));
        assertEquals(testDao.getMonster(002), new Monster("SirScaryMonster", MonsterType.SWAMPTHING, 55, "fishy people"));

    }

    @Test
    void removeMonster() {
        testDao.addMonster(002, new Monster("Medusa", MonsterType.SWAMPTHING, 100, "stone"));
        testDao.removeMonster(002);
        assertNotNull(testDao.getAllMonsters());
        assertEquals(0, testDao.getAllMonsters().size());
    }
}