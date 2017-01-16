    /**
     * conner case s.length()<= 1
     * convert string to all lowercase
     * two pointer to compare begin and last
     * if it is not char or digit, ignore it !Character.isLetterorDigit(left), (right), !=, else++
     **/
     
     
        public static boolean isPalindrome(String s) {
            if(s.length() <= 1) return true;
            int left = 0, right = s.length()-1;
            s = s.toLowerCase();

            while(left < right){
                if(!Character.isLetterOrDigit(s.charAt(left))){
                    left++;
                }else if(!Character.isLetterOrDigit(s.charAt(right))){
                    right--;
                }else if(s.charAt(left) != s.charAt(right)){
                    return false;
                }else{
                    left++;
                    right--;
                }
            }
            return true;
        }
