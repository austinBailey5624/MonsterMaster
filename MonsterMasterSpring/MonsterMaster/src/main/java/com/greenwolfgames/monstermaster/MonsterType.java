package com.greenwolfgames.monstermaster;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


/**
 * Class to model the dabatase table monster_type
 * 
 * @author Austin Bailey
 * 
 * @copyright Austin Bailey 2025 All Rights Reserved
 */
@Entity
public class MonsterType
{
    @Id
    @Column(name = "monster_type_id")
    private Integer monsterTypeId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "element_id", nullable = false)
    private Integer elementId;

    @ManyToOne
    @JoinColumn(name = "physical_evolution")
    private Integer physicalEvolution;

    @ManyToOne
    @JoinColumn(name = "balanced_evolution")
    private Integer balancedEvolution;

    @ManyToOne
    @JoinColumn(name = "magical_evolution")
    private Integer magicalEvolution;

    @ManyToOne
    @JoinColumn(name = "previous_evolution")
    private Integer previousEvolution;

    @ManyToOne
    @JoinColumn(name = "monster_type_image")
    private String monsterTypeImage;

    public MonsterType()
    {

    }

    public MonsterType(Integer monsterTypeId, String name, String description, Integer elementId, Integer physicalEvolution,
     Integer balancedEvolution, Integer magicalEvolution, Integer previousEvolution, 
     String monsterTypeImage)
    {
        this.monsterTypeId = monsterTypeId;
        this.name = name;
        this.description = description;
        this.elementId = elementId;
        this.physicalEvolution = physicalEvolution;
        this.balancedEvolution = balancedEvolution;
        this.magicalEvolution = magicalEvolution;
        this.previousEvolution = previousEvolution;
        this.monsterTypeImage = monsterTypeImage;
    }
}