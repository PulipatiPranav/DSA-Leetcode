class SingleNumber2{

    //The approach to solving this problem is to count the number of set bits 
    //column wise, each repeated element is repeated thrice, so it contributes
    //to the count exactly thrice or in the multiples of three, while the element
    //that is distinct doesnt contribute in the multiples of three. So each time 
    //we count the number of set bits column wise, and if the count is not a 
    //multiple of three, we set the bit at that indice, and the final result
    //return the result.
    
    public int Solution(int arr[]){
        int result = 0;

        for(int num: arr){
            //for each num in array, we iterate through 32 bits as its an int
            int count = 0; //number of set bits
            for(int i =0 ; i < 32; i++){
                if((num & 1<<i)!=0) count++; //count set bits
                if(count  %3!=0){
                result = result | (1 <<i); //if not multiple of three, set bit
            }
            }
            
        }
        return result; //return final result

    }
}