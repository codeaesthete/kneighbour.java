import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;


class sample {

    public static void main(String[] args) {
        System.out.println("Welcome To K_Nearest Neighbour Algorithm");
        System.out.println("Enter number of data sets:");

        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        String[] name = new String[t];
        double[] height = new double[t];
        String[] label = new String[t];

        for (int i = 0; i < t; i++) {
            System.out.print(i + 1+")");
            System.out.print(" Enter your Name: ");
            name[i] = scn.next();
            System.out.println();
            System.out.print("Enter " + name[i] + "'s height: ");
            height[i] = scn.nextDouble();
            System.out.println();
            System.out.print("Enter " + name[i] + "'s class: ");
            label[i] = scn.next();
        }
         System.out.println("Enter the person's name whoose class is to be found");
         String peru=scn.next();
        System.out.println("Enter "+ peru +"'s"+ " height");
        double h =scn.nextDouble();
        System.out.println("Enter the K_neighbour value");
        int k=scn.nextInt();
        double[] distance = new double[t];
        for(int i=0;i<t;i++){
            distance[i]=Math.abs(h-height[i]);
        }
        double[][] result = new double[3][2];
        double[] smallest1 = {Double.MAX_VALUE, -1};
        double[] smallest2 = {Double.MAX_VALUE, -1};
        double [] smallest3 = {Double.MAX_VALUE, -1};
         

        for (int i = 0; i < distance.length; i++) {
            if (distance[i] < smallest1[0]) {
                smallest3[0] = smallest2[0];
                smallest3[1] = smallest2[1];
                smallest2[0] = smallest1[0];
                smallest2[1] = smallest1[1];
                smallest1[0] = distance[i];
                smallest1[1] = i;
            } else if (distance[i] < smallest2[0]) {
                smallest3[0] = smallest2[0];
                smallest3[1] = smallest2[1];
                smallest2[0] = distance[i];
                smallest2[1] = i;
            } else if (distance[i] < smallest3[0]) {
                smallest3[0] = distance[i];
                smallest3[1] = i;
            }
        }

        result[0] = smallest1;
        result[1] = smallest2;
        result[2] = smallest3;
        HashMap<String,Double> Map = new HashMap<>();
        for (int i=0;i<k;i++) {
           // Map.put(label[result[i][1]], Map.getOrDefault(label[result[i][1]], 0.0) + 1.0);
           int index = (int) result[i][1];
Map.put(label[index], Map.getOrDefault(label[index], 0.0) + 1.0);
        }
        double max_freq=Double.MIN_VALUE;
        String answer= " ";
        for(Map.Entry<String,Double> entry:Map.entrySet()){
            if(entry.getValue()>max_freq){
                answer=entry.getKey();
            }
        }

        System.out.println(peru+"with height "+ h+ " belongs to "+answer+" class");


       
    }
}