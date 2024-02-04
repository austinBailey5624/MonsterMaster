package main;

import java.util.List;

/**
 * Interface for retrieving the content of the game
 * @author Austin Bailey 2024 All Rights Reserved
 * 
 */
public interface ContentRetriever
{
	public List<String> getPrompt(int scenario_id);
	
	public List<String> getChoices(int scenario_id);
}
