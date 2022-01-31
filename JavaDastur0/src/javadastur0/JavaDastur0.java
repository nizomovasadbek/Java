package javadastur0;
public class JavaDastur0 {
    public static void main(String[] args) {
       boolean[][] massiv = new boolean[4][6];
       boolean a, b;
       System.out.println("A        B      A|B      A&B      A^B     ~A");
       massiv[0][0] = a = false;
       massiv[0][1] = b = false;
       massiv[0][2] = a | b;
       massiv[0][3] = a & b;
       massiv[0][4] = a ^ b;
       massiv[0][5] = !a;
       massiv[1][0] = a = true;
       massiv[1][1] = b = false;
       massiv[1][2] = a | b;
       massiv[1][3] = a & b;
       massiv[1][4] = a ^ b;
       massiv[1][5] = !a;
       massiv[2][0] = a = false;
       massiv[2][1] = b = true;
       massiv[2][2] = a | b;
       massiv[2][3] = a & b;
       massiv[2][4] = a ^ b;
       massiv[2][5] = !a;
       massiv[3][0] = a = true;
       massiv[3][1] = b = true;
       massiv[3][2] = a | b;
       massiv[3][3] = a & b;
       massiv[3][4] = a ^ b;
       massiv[3][5] = !a;
       
       for(int i = 0; i < 4; i++)
           for(int j = 0; j < 6; j++){
               System.out.print(massiv[i][j] + "   ");
               if(j == 5) System.out.println();
           }
    }   
}