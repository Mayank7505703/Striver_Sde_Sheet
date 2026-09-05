class Solution {
    public boolean lemonadeChange(int[] bills) {
        int f=0;
        int t=0;
        int tw=0;
        for(int i =0;i<bills.length;i++){
            if(bills[i]==5){
                f++;
            }
            else if(bills[i]==10 && f>=1){
                f--;
                t++;
            }
            else if(bills[i]==20 && t>=1 && f>=1){
                t--;
                f--;
                tw++;
            }
            else if(bills[i]==20 && f>=3){
                f-=3;
                tw++;
            }
                
            else{
                return false;
            }
        }
        return true;
    }
}