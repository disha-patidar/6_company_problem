int[][] rects;
    int[] range;
    int totArea = 0;
    Random r = new Random();

    public Solution(int[][] rects) {
        this.rects = rects;
        range = new int[rects.length];
        int id = 0; 
        for(int[] rect : rects){
            int area = Math.abs((rect[2]-rect[0]+1) * (rect[3]-rect[1]+1));
            this.totArea = this.totArea + area;
            range[id++] = totArea;
        }
    }
    
    public int[] pick() {
        
        int[] res = new int[2];
        int area = r.nextInt(totArea+1);
        
        /*
        
        Solution without binary search
        
        int index = 0;
        while(index < range.length && range[index] < area){
            index++;
        }
        
        */
        
        int index = bs(area, 0, range.length-1);
        
        int[] rect = rects[index];
     
        res[0] = rect[0] + (r.nextInt(rect[2]-rect[0]+1));
        res[1] = rect[1] + (r.nextInt(rect[3]-rect[1]+1));

        return res;
        
    }
    
    public int bs(int area, int start , int end){
        
        int mid = 0;
        while(start != end){
            mid = ((end+start)/2);
            if(area >= range[mid]){
                 start = mid+1; 
            }else{
               end = mid;
            }
        }
        return start;
    }
