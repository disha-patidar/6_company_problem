class Solution {
     public boolean checkOverlap(int radius, int x_center, int y_center, int x1, int y1, int x2, int y2) {
        int d_x1 = x_center - x1; 
        int d_x2 = x_center - x2;
        int d_y1 = y_center - y1;
        int d_y2 = y_center - y2;
        int square = radius * radius;
        int x_top = x_center + radius;
        int x_bottom = x_center - radius;
        int y_top = y_center + radius;
        int y_bottom = y_center - radius;
        boolean insideX = (x_center >= x1) && (x_center <= x2);
        boolean insideY = (y_center >= y1) && (y_center <= y2);
        
        if ((d_x1 * d_x1 + d_y1 * d_y1 <= square) || (d_x2 * d_x2 + d_y1 * d_y1 <= square) || (d_x1 * d_x1 + d_y2 * d_y2 <= square) || (d_x2 * d_x2 + d_y2 * d_y2 <= square)) {
            return true;
        }
        if (((square - d_x1 * d_x1 >= 0) && insideY) || ((square - d_x2 * d_x2 >= 0) && insideY) || ((square - d_y1 * d_y1 >= 0) && insideX) || ((square - d_y2 * d_y2 >= 0) && insideX)) {
            return true;
        }
        // Circle inside the square.
        if ((x_top <= x2) && (x_bottom >= x1) && (y2 >= y_top) && (y1 <= y_bottom)) return true;
        return false;
    }
}
