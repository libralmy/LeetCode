/**
*@param number : input a int
*@return void: add number into structure
* 
* @param value: a given int
* @return boolean: find if any pair of numbers which sum is equal to value
* 
* initial a map<number, frequence>
* a list that contain ALL numbers
* 
* add() -> use hashmap to check 
* fint() -> forloop all the elem in the list
*           need to consider about num1 = num2
* 
**/
/** Test case
*public class Test {
    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter String");
        String s = br.readLine();
        System.out.print("Enter Integer:");
        try{
            int i = Integer.parseInt(br.readLine());
        }catch(NumberFormatException nfe){
            System.err.println("Invalid Format!");
        }
    }
}
* 
**/

public class TwoSum {

    public Map<Integer, Integer> map = new HashMap<>();
    public List<Integer> list = new ArrayList<>();
    // Add the number to an internal data structure.
    public void add(int number) {
        if(!map.containsKey(number)){
            map.put(number, 0);
            list.add(number);
        }else{
            map.put(number, map.get(number)+1);
        }

    }

    // Find if there exists any pair of numbers which sum is equal to the value.
    public boolean find(int value) {
        for(int i = 0; i < list.size(); i++){
            int num1 = list.get(i);
            int num2 = value - num1;
            
            if((num1 == num2 && map.get(num1) == 1) || (num1 != num2 && map.containsKey(num2))){
               return true;
            }
        }
        return false;

    }
	
}


// Your TwoSum object will be instantiated and called as such:
// TwoSum twoSum = new TwoSum();
// twoSum.add(number);
// twoSum.find(value);
