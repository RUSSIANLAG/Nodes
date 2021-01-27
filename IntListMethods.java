public class IntListMethods {


	public static String getAuthorName()
	{
		return "Golovine, Ivan";
	}
	public static String getRyersonID()
	{
		return "500813431";
	}

	public static int removeIfDivisible(int n, int k)
	{
		if(n == 0) { return 0; }
		int first = n;
		int m = IntList.getNext(n);
		//int kik = 0;
		while(IntList.getKey(n)%k == 0) {
			first = IntList.setNext(n, 0);
			//kik = first;
			IntList.release(n);
			n=m;
			m = IntList.getNext(m);
        }
		while(m != 0)
		{
			if (IntList.getKey(m)%k != 0)
			{
				//kik = m;
				n = m;
				m = IntList.getNext(m);
			}

			else if (m!=0 && IntList.getKey(m)%k == 0)
			{
			 	int j = IntList.getNext(m);
				//IntList.setNext(kik, IntList.setNext(m, 0));
			 	IntList.setNext(n, IntList.setNext(m, 0));
				IntList.release(m);
				m = j;
			}
		}
		return first;
	}
	public static int sort(int n)
	{
		if (n == 0 || IntList.getNext(n)==0)
		{
			return n;
		}
		//get middle

			int middle = getMiddle(n);
			int nextOfMiddle = IntList.getNext(middle);
			IntList.setNext(middle, 0);
			//int k =mergeTwoListIterative(sort(n), sort(nextOfMiddle));


		//merge
		return mergeTwoListIterative(sort(n), sort(nextOfMiddle));
	}




	private static int mergeTwoListIterative(int leftStart, int rightStart) {
		int merged=0;
		int temp=0;
		int lastAddedNode = 0;

		while (leftStart != 0 && rightStart!=0)
		{
			if (IntList.getKey(leftStart) > IntList.getKey(rightStart))
			{
				temp = rightStart;
				rightStart = IntList.getNext(rightStart);
			}
			else
			{
				temp = leftStart;
				leftStart = IntList.getNext(leftStart);
			}
			if(merged == 0)
			{
				merged = temp;
			}
			else
			{
				IntList.setNext(lastAddedNode, temp);
			}
			lastAddedNode = temp;
		}

		if(leftStart != 0)
		{
			IntList.setNext(lastAddedNode, leftStart);
		}
		else{
			IntList.setNext(lastAddedNode, rightStart);
		}
		return merged;
	}



	private static int getMiddle(int startNode) {
		  if(startNode==0){
		   return startNode;
		  }
		  int pointer1=startNode;
		  int pointer2=startNode;

		  while(pointer2!=0 && IntList.getNext(pointer2)!=0 && IntList.getNext(IntList.getNext(pointer2))!=0){
		   pointer1 = IntList.getNext(pointer1);
		   pointer2 = IntList.getNext(IntList.getNext(pointer2));

		  }
		  return pointer1;
		 }

}
