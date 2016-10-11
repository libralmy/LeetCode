    /***use hashset to count the palidrome, so there is no if condition for even or odd length of string
     * if hashset.size() <= 1 that means all the duplicated char is been removed*****/
    /**
     * use char[] letterMap if contains the char => it doesnt say the lowercase, 
     * so int[128], the lowest ASCII is ' 'space
     * ***/
    public static boolean canPermutePalindrome(String s) {
        if(s.length() == 0) return false;
        int[] letterMap = new int[128];
        if(s.length()%2 == 0) {
            for (int i = 0; i<s.length()/2 ; i++) {
                letterMap[s.charAt(i) - ' ']++;
            }
            for(int i = s.length()-1 ; i>=s.length()/2 ; i--){
                letterMap[s.charAt(i) - ' ']--;
            }
        }else{
            for (int i = 0; i<s.length()/2 ; i++) {
                letterMap[s.charAt(i) - ' ']++;
            }
            for(int i = s.length()-1 ; i>s.length()/2 ; i--){
                letterMap[s.charAt(i) - ' ']--;
            }
        }
        for(int n : letterMap){
            if(n != 0)return false;
        }
        return true;
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
