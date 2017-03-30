import java.util.*;

class PageCalculator {

	public static void main(String[] args) {
		
		//String allPages = "1-100";
		String allPages = "1,2,3,4,5,6";
		//TODO: warn for excluded Pages, not in the Page list. -> Use try / exept
		String input = "1,2,6";



		String [] myString; 

		int lowerBoundary;
		int upperBoundary;
		int temp;

		
		TreeSet<Integer> myTreeSet = new TreeSet<Integer>();
		TreeSet<Integer> myTreeSetAllPages = new TreeSet<Integer>();

		
		// Split String.
		myString = input.split(",");

		// Search for - and resplit / rewrite String again.
		for(int i = 0; i < myString.length; i++)
		{
			if(myString[i].contains("-"))
			{
				lowerBoundary = Integer.parseInt( myString[i].substring( 0, myString[i].indexOf("-") ) );
				upperBoundary = Integer.parseInt( myString[i].substring( myString[i].indexOf("-") + 1 ) );

				// Sort lower and upper Boundary
				if(lowerBoundary > upperBoundary)
				{
					temp = lowerBoundary;
					lowerBoundary = upperBoundary;
					upperBoundary = temp;
				}

				// Populate list.				
				for(int actValue = lowerBoundary; actValue<= upperBoundary; actValue++)
				{
					// Add component to TreeSet.
					myTreeSet.add(actValue);
				}
			}
			else
			{
				// Add component to TreeSet.
				myTreeSet.add( Integer.parseInt( myString[i] ) );
			}
		}
		
		// Set all Pages in TreeSet. TODO: use above algorithm for TreeSet creation.
		for(int i = 0; i < allPages.length; i++)
		{
			myTreeSetAllPages.add( allPages[i] );
		}
		
		// Defined Pages minus input Pages		
		myTreeSetAllPages.removeAll(myTreeSet);
		

		// Print TreeSets.
		//System.out.println(myTreeSet);
		//System.out.println(myTreeSetAllPages);
		
		// Convolute Page list with - to save space.
		TreeSet<Integer> tree = new TreeSet<Integer>();
		tree = myTreeSetAllPages;
		
		int current, next;
		boolean isNotFirst=false;
		int last = tree.last();
		
		while(0 < tree.size())
		{
			current = tree.pollFirst();
			
			if(current == last)
			{
				System.out.print(current);
			}
			else
			{
				next = tree.higher(current);
				
				if(next == (current + 1))
				{
					if(isNotFirst == false)
					{
						System.out.print(current);
						System.out.print("-");;
						isNotFirst = true;
					}
					else
					{
						// Do nothing.
					}
				}
				else
				{
					System.out.print(current);
					System.out.print(",");
					isNotFirst = false;
				}
			}
		}
		

		
		
	}

	

}
