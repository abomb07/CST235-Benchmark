
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class BibleBusinessService {

	@EJB
	BibleDataService bds;
	
	public BibleBusinessService()
	{
		
	}
	
	public String findOccurences(String word)
	{
		//get all of john 1
		String j1 = bds.findAll();
		//remove special chars
		j1 = j1.replaceAll("\\p{P}", "");
		//lowercase everything
		j1 = j1.toLowerCase();
		//remove extra spaces
		j1 = j1.replaceAll(" +", " ");
		
		//split into individual words
		String temp[] = j1.split(" ");
				
		//counter of word
		int count = 0;
		
		//loop through bible and find occurences
		for (int i = 0; i < temp.length; i++) 
		{
			if (word.equals(temp[i])) 
			{
				count++;
			}
		}
		return "In John 1, '" + word + "' occurs " + count + " times.";
	}
}
