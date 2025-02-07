package com.greenwolfgames.monstermaster;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

/**
 * Class to model the database table nature_abstract
 * 
 * @author Austin Bailey
 * 
 * @copyright Austin Bailey 2025 All Rights Reserved
 */
@Entity
public class NatureAbstract {

    @Id
    @Column(name = "nature_abstract_id")
    private Integer natureAbstractId;

    @ManyToOne
    @JoinColumn(name = "nature_id", nullable = false)
    private Nature nature;

    @Column(name = "abstract")
    private String abstractString;

    public NatureAbstract()
    {

    }

    public NatureAbstract(Integer natureAbstractId, Nature nature, String abstractString)
    {
        this.natureAbstractId = natureAbstractId;
        this.nature = nature;
        this.abstractString = abstractString;
    }

    @Override
    public String toString() {
        return "NatureAbstract{" + "natureAbstractId=" + natureAbstractId + "natureId=" + nature + "abstract=" + abstractString + "}";
    }
}
