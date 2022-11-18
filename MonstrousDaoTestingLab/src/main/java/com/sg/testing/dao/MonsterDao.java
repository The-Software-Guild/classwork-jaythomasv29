/*********************************
* The Software Guild
* Copyright (C) 2020 Wiley edu LLC - All Rights Reserved
*********************************/
package com.sg.testing.dao;

import com.sg.testing.model.Monster;
import java.util.List;

public interface MonsterDao {
    
    /**
     *
     * A method to store a monster in memory under an id.
     * 
     * @param id - a unique id for your monster
     * @param m - the monster to store under that id
     * @return any monster already stored under that id
     */
    public Monster addMonster(int id, Monster m);

    /**
     *
     * A method to get a monster by its unique id.
     * 
     * @param id - the unique id a monster has been stored under.
     * @return a monster if one is stored, null if not
     */
    public Monster getMonster(int id);

    /**
     *
     * A way to get all stored monsters.
     * 
     * @return A list, never null, of all monsters stored.
     */
    public List<Monster> getAllMonsters();

    /**
     *
     * A method to update an already stored monster.
     * 
     * @param id - the unique id your monster is stored by
     * @param m - the monster to be updated
     */
    public void updateMonster(int id, Monster m);

    /**
     *
     * A method to remove a monster from storage.
     * 
     * @param id - the unique id of the monster stored
     * @return the monster removed if it was stored, null if not
     */
    public Monster removeMonster(int id);
    
}
