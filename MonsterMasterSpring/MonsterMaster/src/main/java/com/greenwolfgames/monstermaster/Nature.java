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
    private final Integer natureId;

    @Column(name = "name", nullable = false)
    private final String name;

    @Column(name = "primaryColor")
    private final String primaryColor;

    public Nature(Integer natureId, String name, String primaryColor)
    {
        this.natureId = natureId;
        this.name = name;
        this.primaryColor = primaryColor;
    }

    public Integer getNatureId()
    {
        return natureId;
    }

    public String getName()
    {
        return name;
    }

    public String getPrimaryColor()
    {
        return primaryColor;
    }
}
