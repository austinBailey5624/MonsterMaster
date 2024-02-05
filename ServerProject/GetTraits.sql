-- this SQL file assumes that ServerSetup has been executed before it can work
Select subquery.traits_name, subquery.trait_name, trait_intensity_lookup.intensity
FROM ( Select traits.traits_id, traits.traits_name, trait.trait_id, trait.trait_name from traits cross join trait) AS subquery
Right Join trait_intensity_lookup on  subquery.traits_id = trait_intensity_lookup.traits_id AND subquery.trait_id = trait_intensity_lookup.trait_id;
