
//The approach is to sort the cars based on their position in descending order. Then we calculate the time it takes
//for each car to reach the target. If the time for a car is greater than the last recorded time, it means that this
//car forms a new fleet, and we update the last recorded time to the current car's time. Finally, we return the total
//number of fleets formed.
import java.util.*;

class CarFleet {
    public int carFleet(int target, int[] position, int[] speed) {

        int n = position.length;
        int[][] cars = new int[n][2];
        for (int i = 0; i < n; i++) {

            cars[i][0] = position[i];
            cars[i][1] = speed[i];

        }

        Arrays.sort(cars, (a, b) -> b[0] - a[0]);
        int fleets = 0;
        double lastTime = 0;
        for (int i = 0; i < n; i++) {
            double time = (double) (target - cars[i][0]) / cars[i][1];

            if (time > lastTime) {
                lastTime = time;
                fleets++;
            }

        }
        return fleets;

    }
}