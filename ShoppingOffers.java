class Solution {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
return help(price,special,needs,0); 
    }
    public int help(List<Integer> price, List<List<Integer>> special, List<Integer> needs,int start){
        int sum = 0;
        for(int i=0;i<needs.size();i++){
            sum = sum + needs.get(i) * price.get(i);
        }
        for(int i=start;i<special.size();i++){
            List<Integer> list = special.get(i);
            List<Integer> temp = new ArrayList<>();
            for(int j=0;j<needs.size();j++){
                if(needs.get(j) < list.get(j)){
                    temp = null;
                    break;
                }// invalid offer
                temp.add(needs.get(j) - list.get(j));
            }
            if(temp != null){
                sum = Math.min(sum,list.get(list.size()-1) + help(price,special,temp,i));
            }

        }
        return sum;
    }
}
