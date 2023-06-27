import java.util.*;

/**
형변환 long->double 연산시 소수점 버려지는것 확인
최대 최소값은 Long.MIN_VALUE Long.MAX_VALUE를 사용하자
**/

class Solution {   
    public String[] solution(int[][] line) {
        List<Point> pointList = new ArrayList<>();
        
        // max min
        long Mx = Long.MIN_VALUE;
        long My = Long.MIN_VALUE;
        long mx = Long.MAX_VALUE;
        long my = Long.MAX_VALUE;
        
        for(int i = 0; i<line.length; i++){
            for(int j = 1+i; j<line.length; j++){
                long A = line[i][0];
                long B = line[i][1];
                long E = line[i][2];
                long C = line[j][0];
                long D = line[j][1];
                long F = line[j][2];
                
                if((A*D-B*C)==0L) continue;
                double x = (double)((B*F)-(E*D))/((A*D)-(B*C));
                double y = (double)((E*C)-(A*F))/((A*D)-(B*C));
                
                if(x%1 == 0 && y%1 ==0){
                    pointList.add(new Point((long)x,(long)y));
                    if(x>Mx) Mx = (long)x;
                    if(x<mx) mx = (long)x;
                    if(y>My) My = (long)y;
                    if(y<my) my = (long)y;
                }
            }
        }
    
        int xsize = (int)(Mx-mx+1);
        int ysize = (int)(My-my+1);
        char[][] star = new char[ysize][xsize]; // 초기화
        for(int i=0;i<ysize;i++){
            for(int j=0;j<xsize;j++){
                star[i][j]='.';
            }
        }
        
        for(Point p : pointList){
            star[(int)(My-p.y)][(int)(p.x-mx)] = '*';
            // System.out.println(p.x+","+p.y);
        }

        String[] answer = new String[star.length];
        for(int i =0;i<star.length;i++){
            answer[i] = new String(star[i]);
        }
        
        return answer;
    }
    
    
    
    private static class Point{
        public final long x,y;
        public Point(long x, long y){
            this.x=x;this.y=y;
        }
        
    }
    
}