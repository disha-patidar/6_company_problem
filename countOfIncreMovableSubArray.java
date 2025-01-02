 public boolean increasing(ArrayList<Integer> al) {
       for (int i = 0; i < al.size() - 1; i++) {
           if (al.get(i + 1) <= al.get(i)) {
               return false; 
           }
       }
       return true;
   }
   public int incremovableSubarrayCount(int[] nums) {
       int count = 0;
       for (int i = 0; i < nums.length; i++) {
           for (int j = i; j < nums.length; j++) {
               ArrayList<Integer> al = new ArrayList<>();
               for (int k = 0; k < nums.length; k++) {
                   if (k < i || k > j) {
                       al.add(nums[k]);
                   }
               }
               if (increasing(al)) {
                   count++;
               }
           }
       }

       return count;
   }
