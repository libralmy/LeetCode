    /***use hashset to count the palidrome, so there is no if condition for even or odd length of string
     * if hashset.size() <= 1 that means all the duplicated char is been removed*****/
    /**
     * use char[256] letterMap if contains the char => it doesnt say the lowercase, 
     * counter++, A[]++ when letterMap[s.charAt(i)]> 0, else --
     * return counter <= 1
     * ***/
public boolean canPermutePalindrome(String s) {
    char[] A = new char[256];
    int count=0;
    for(int i=0; i<s.length(); i++){
        if(A[s.charAt(i)]>0) {
            A[s.charAt(i)]--;
            count--;
        } else {
            A[s.charAt(i)]++;
            count++;
        }
    }
    return count<=1;

        /*
        Set<Character> countSet = new HashSet<>();
        for(char c : s.toCharArray()){
            if(countSet.contains(c)){
                countSet.remove(c);
            }else{
                countSet.add(c);
            }
        }
        return countSet.size()<=1;
        */
    }
