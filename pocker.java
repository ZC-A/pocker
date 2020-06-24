import java.util.*;
     // This program  aims to compare the poker, poker has a number and a color
     
   //Poker has 13 numbers,  ascending order :   2, 3, 4, 5, 6, 7, 8, 9, T, J, Q, K, A
             // and four color : D Diamond , S Spade , H heart , C Club , color doesn't has order 
                

public class pocker {
	
	  public static char numbers[] = {2,3,4,5,6,7,8,9,'T','J','Q','K','A'}; 
	  
	  public static String Numbers = new String(numbers);
	  
	  public static void main(String[] args) {
    	  Scanner s = new Scanner(System.in);
    	  
    	  ArrayList<card> Black = new ArrayList<card>();
    	  ArrayList<card> White = new ArrayList<card>();
    	  
    	  String Blackstr = s.nextLine();
    	  String Whitestr = s.nextLine();
    	  
    	  String [] blackstr = Blackstr.split("\\s+");
    	  String [] whitestr = Whitestr.split("\\s+");
    	  
    	  for(int i=0;i<blackstr.length;i++){
    		     Black.add(new card(blackstr[i].charAt(0),blackstr[i].charAt(1)));
    	  }
    	  
    		  for(int i=0;i<whitestr.length;i++) {
    			  White.add( new card(whitestr[i].charAt(0),whitestr[i].charAt(1)));
    		  }
    		  
    		  card.cardCompare(Black,White);
    		  
    	  }
     }
class cardComparator implements Comparator<card>{

	@Override
	public int compare(card A, card B) {
		// TODO Auto-generated method stub          card comparator
		return  pocker.Numbers.indexOf(A.Num) - pocker.Numbers.indexOf(B.Num);
	}
}

class card {
	char Num, Color;
	
	card(char num,char color){
		Num = num;                   //constructor :  a card with a number and a color 
		Color = color;
	}
	
	public static void cardCompare(ArrayList<card>black,ArrayList<card> white) {
		   
		if(SameColorAndConsistent(black)!=null||SameColorAndConsistent(white)!=null) {
			    if(SameColorAndConsistent(black)!=null && SameColorAndConsistent(white) == null) {        //To compare the cards 
			    	    System.out.println("Black wins");
			    	    return ;
			    }else if(SameColorAndConsistent(black) == null && SameColorAndConsistent(white) != null) {
			    	    System.out.println("White wins");
			    	    return ;
			    }else {
			    	  System.out.println(compare(black,white));
			    	  return ;
			    }
		}else if(sameColor(black)||sameColor(white)) {
			    if(sameColor(black) && !sameColor(white)) {
			    	 System.out.println("Black wins");
			    	 return ;
			    }else if(!sameColor(black) && sameColor(white)) {
			    	  System.out.println("White wins");
			    	  return ;
			    }else {
			    	System.out.println(compare(black,white));
			    	return;
			    }
		}else if(isThird(black)!=null||isThird(white)!=null) {
			    if(isThird(black)!=null && isThird(white)==null) {
				   System.out.println("Black wins");
				   return ;
			   }else if (isThird(black)==null && isThird(white)!=null) {
				   System.out.println("White wins");
				   return ;
			   }else if(Compare(isThird(black),isThird(white))>0) {
				   System.out.println("Black wins");
				   return ;
			   }else if(Compare(isThird(black),isThird(white))<0) {
				   System.out.println("white wins");
				   return ;
			   }else {
				   card temp = isThird(black);
				   for(card A:black) {
					   if(A.Num == temp.Num) {
						   black.remove(A);
					   }
				   }
				   for(card B:white) {
					   if(B.Num == temp.Num) {
						   white.remove(B);
					   }
				   }
				   System.out.println(compare(black,white));
				   return ;
			   }				    
		}else if(hasTwoPair(black)!=null||hasTwoPair(white)!=null) {
			   if(hasTwoPair(black)!=null && hasTwoPair(white)==null) {
				   System.out.println("Black wins");
				   return ;
			   }else if(hasTwoPair(black)==null &&hasTwoPair(white)!=null) {
				   System.out.println("White wins");
				   return ;
			   }else if(Compare(hasTwoPair(black),hasTwoPair(white))>0) {
				   System.out.println("Black wins");
				   return ;
			   }else if(Compare(hasTwoPair(black),hasTwoPair(white))<0) {
				   System.out.println("White wins");
				   return ;
			   }else {
				     card temp = hasTwoPair(black);
				     for(card A:black) {
						   if(A.Num == temp.Num) {
							   black.remove(A);
						   }
					   }
					   for(card B:white) {
						   if(B.Num == temp.Num) {
							   white.remove(B);
						   }
					   }
					  card.cardCompare(black, white);
					  return ;
			   }
		}else if(isPair(black)!=null||isPair(white)!=null) {
			   if(isPair(black)!=null && isPair(white)==null) {
				    System.out.println("Black wins");
				    return ;
			   }else if(isPair(black)==null && isPair(white)!=null) {
				   System.out.println("White wins");
				   return ;
			   }else {
				    card temp = isPair(black);
				    for(card A:black) {
						   if(A.Num == temp.Num) {
							   black.remove(A);
						   }
					   }
					   for(card B:white) {
						   if(B.Num == temp.Num) {
							   white.remove(B);
						   }
					   }
					   System.out.println(compare(black,white));
					   return ;
			   }
		}else {
			System.out.println(compare(black,white));
		}
	}
	
	private static boolean equal(card A, card B) {
		 
		if(A.Color == B.Color && A.Num == B.Num ) {
			 return true;
		 }                               //to judge two cards are equal or not
		 return false;
	   }
	
	private static card compare(card A,card B) {
		  return  pocker.Numbers.indexOf(A.Num) >=  pocker.Numbers.indexOf(B.Num) ? A : B;      //compare by order
	}
	
	private static int Compare(card A,card B) {
		 return pocker.Numbers.indexOf(A.Num) - pocker.Numbers.indexOf(B.Num);
	}
	
	private static  String compare(List<card> A,List<card> B) {
		  Collections.sort(A,new cardComparator());
		  Collections.sort(B,new cardComparator());
		  
		  Collections.reverse(A);
		  Collections.reverse(B);
		        // @override 
		  
		  for(int i=0;i<A.size();i++) {
			  if(Compare(A.get(i),B.get(i))>0) {
				  return  "Black wins";
			  }else if (Compare(A.get(i),B.get(i))<0) {
				  return "White wins";
			  }
		  }
		  
		  return "Tie";
	}
	
	private static  card isPair(ArrayList<card> A) {       
		 for(int i = 0; i<A.size()-1; ++i) {
			for(int j = i+1;j<A.size();++j) {             // to find out whether cards have Pair 
				if(equal(A.get(i),A.get(j))) {  
					return A.get(i);
				}
			}
		 }
		 return null;
	}

	private static  card isThird(ArrayList<card> A) {
		 
		if(isPair(A) == null) {
			 return null;
		 }
		
		 for(int i=0;i<A.size();i++) {                           
			 for(int j=0;j<A.size();j++) {
				  if(equal(A.get(i),A.get(j))) {
					  if(j==A.size()-1) {                                // to find out whether cards have three cards that are the same
						  return null;
					  }
					 for(int k=j+1;k<A.size();k++) {
						 if(equal(A.get(j),A.get(k))) {
							 return A.get(i);
						 }
					 }
				  }
			 }
		 }
		 return null;
	}
	
	private static card hasTwoPair(ArrayList<card> A) {
		 
		card temp = (isPair(A));
		 if(temp == null) {
			 return null;
		 }
		 
		 for(int i=0;i<A.size();i++) {
			 for(int j=i+1;j<A.size();j++) {
				 if(equal(A.get(i),A.get(j))&&!equal(A.get(i),temp)) {
					 return  compare(A.get(i),temp);
				 }
			 }
		 }
		return null;
	}
	
	private static card consistent(ArrayList<card> A) {
		
		Collections.sort(A,new cardComparator());
		Collections.reverse(A);
		
		for(int i=0;i<A.size();i++) {
			if(A.get(i+1).Num-A.get(i).Num!=1) {
				return null;
			}
		}
		return A.get(A.size()-1);
	}
	
	private static boolean sameColor(ArrayList<card>A) {
		
		for(int i=0;i<A.size()-1;i++) {
			if(A.get(i).Color!=A.get(i+1).Color) {
				return false;
			}
		}
		return true;
	}
	
	private static card SameColorAndConsistent(ArrayList<card> A) {
		
		card temp = consistent(A);
		if(A!=null&&sameColor(A)) {
			return temp;
		}
		return null;
	}    
}
