package com.greenwolfgames.monstermaster;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/**
 * Class to model the database table nature
 * 
 * @author Austin Bailey
 * 
 * @copyright Austin Bailey 2025 All Rights Reserved.
 */
@Entity
public class Nature 
{
    @Id
    @Column(name = "nature_id")
    private Integer natureId;

    @Column(name = "name", nullable = false)
    private String name;

    public Nature()
    {

    }

    public Nature(Integer natureId, String name)
    {
        this.natureId = natureId;
        this.name = name;
    }

    public Integer getNatureId()
    {
        return natureId;
    }

    public String getName()
    {
        return name;
    }


    @Override
    public String toString() {
        return "Nature{" +
                "natureId=" + natureId +
                ", name='" + name + 
                "'}";
    }
}
