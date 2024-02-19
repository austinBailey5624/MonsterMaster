-- this SQL file assumes that ServerSetup has been executed before it can work
Select subquery.traits_name, subquery.trait_name, trait_intensity_lookup.intensity
FROM ( Select trait_manager.trait_manager_id, trait_manager.traits_name, trait.trait_id, trait.trait_name from trait_manager cross join trait) AS subquery
Right Join trait_intensity_lookup on  subquery.trait_manager_id = trait_intensity_lookup.trait_manager_id AND subquery.trait_id = trait_intensity_lookup.trait_id;
