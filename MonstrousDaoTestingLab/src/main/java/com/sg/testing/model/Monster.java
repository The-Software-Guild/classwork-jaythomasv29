/*********************************
* The Software Guild
* Copyright (C) 2020 Wiley edu LLC - All Rights Reserved
*********************************/
package com.sg.testing.model;

import java.util.Objects;

public class Monster {
    
    private String name;
    private MonsterType type;
    private int peopleEaten;
    private String favoriteFood;

    public Monster() {
    }

    public Monster(String name, MonsterType type, int peopleEaten, String favoriteFood) {
        this.name = name;
        this.type = type;
        this.peopleEaten = peopleEaten;
        this.favoriteFood = favoriteFood;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MonsterType getType() {
        return type;
    }

    public void setType(MonsterType type) {
        this.type = type;
    }

    public int getPeopleEaten() {
        return peopleEaten;
    }

    public void setPeopleEaten(int peopleEaten) {
        this.peopleEaten = peopleEaten;
    }

    public String getFavoriteFood() {
        return favoriteFood;
    }

    public void setFavoriteFood(String favoriteFood) {
        this.favoriteFood = favoriteFood;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.name);
        hash = 67 * hash + Objects.hashCode(this.type);
        hash = 67 * hash + this.peopleEaten;
        hash = 67 * hash + Objects.hashCode(this.favoriteFood);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Monster other = (Monster) obj;
        if (this.peopleEaten != other.peopleEaten) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.favoriteFood, other.favoriteFood)) {
            return false;
        }
        if (this.type != other.type) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Monster{" + "name=" + name + ", type=" + type + ", peopleEaten=" + peopleEaten + ", favoriteFood=" + favoriteFood + '}';
    }
    
}
