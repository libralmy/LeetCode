    /***
     * put all the char in the map<charofString, frequence>
     * check the first one that get() is 0**/
    public static int firstUniqChar(String s) {
        /*
        if(s.length() == 0){
            return -1;
        }else if(s.length() <= 2){
            return 0;
        }

        Map<Character, Integer> mapUniqChar = new HashMap<>();
        for(int i =0 ; i<s.length() ; i++){
            if(!mapUniqChar.containsKey(s.charAt(i))){
                mapUniqChar.put(s.charAt(i), 0);
            }else{
                mapUniqChar.put(s.charAt(i),mapUniqChar.get(s.charAt(i))+1);
            }
        }
        for(int i =0 ; i<s.length(); i++){
            if(mapUniqChar.get(s.charAt(i)) !=0)continue;
            else return i;
        }

        return -1;
        */
        int[] letterMap = new int[26];
        //count how many times that char exsited
        for(int i = 0 ; i<s.length() ; i++){
            letterMap[s.charAt(i) - 'a']++;
        }
        //find the uniqe one that only exsited once in the array
        for(int i = 0 ; i<s.length(); i++){
            if(letterMap[s.charAt(i) - 'a'] == 1) return i;
        }
        return -1;

    }
