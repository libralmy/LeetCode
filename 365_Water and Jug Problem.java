
    /**
    * conner case: x+y==z, x==z, y==z, z==0 return true
    * ax+by: diff between x and y z%diff == 0
    **/
    public boolean canMeasureWater(int x, int y, int z) {
        if(z == 0 || x+y == z || x == z || y == z) return true;
        if(z > x +y ) return false;
        return z%diff(x,y) == 0;
    }
    
    public int diff(int x, int y){
        while(y != 0){
            int temp = y;
            y = x%y;
            x = temp;
        }
        return x;
    }
