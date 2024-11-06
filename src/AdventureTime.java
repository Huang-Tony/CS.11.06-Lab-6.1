import java.io.*;
import java.util.Scanner;

public class AdventureTime {

    /** This is the main method and it is where you will test your implementations for challengeOne, challengeTwo, etc.
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        System.out.println(challengeOne("inputOneTwo.txt"));
        System.out.println(challengeTwo("inputOneTwo.txt"));
        System.out.println(challengeThree("inputThreeFour.txt"));
        System.out.println(challengeFour("inputThreeFour.txt"));
    }

    /** TODO 1
     *
     * Challenge 1
     *
     * @param fileName
     * @return Answer to Challenge 1
     * @throws IOException
     */
    public static int challengeOne(String fileName) throws IOException {
        int[] nums = readFile(fileName);
        int decreasingNo = 0;
        int increasingBalls = 0;
        for(int i = 0; i < nums.length-1; i ++){
            if(nums[i] < nums[i+1]){
                increasingBalls ++;
            }
            if(nums[i] > nums[i+1]){
                decreasingNo ++;
            }
        }
        return increasingBalls;
    }

    /** TODO 2
     *
     * Challenge 2
     *
     * @param fileName
     * @return Answer to Challenge 2
     * @throws FileNotFoundException
     */
    public static int challengeTwo(String fileName) throws FileNotFoundException {
        int[] integerBalls = readFile(fileName);
        int ballsCounter = 0;
        for(int i = 0; i < integerBalls.length - 3; i ++){
            if(integerBalls[i] + integerBalls[i+1] + integerBalls[i+ 2] < integerBalls[i+1] + integerBalls[i+2] + integerBalls[i+ 3]){
                ballsCounter++;
            }
        }

        return ballsCounter;
    }

    /** TODO 3
     *
     * Challenge 3
     *
     * @param fileName
     * @return Answer to Challenge 3
     * @throws FileNotFoundException
     */
    public static int challengeThree(String fileName) throws FileNotFoundException {
        String[] depressingBalls = readFile2(fileName);
        StringBuilder balls = new StringBuilder();
        for(int i = 0; i < depressingBalls.length; i ++ ){
            balls.append(depressingBalls[i]).append(" ");
        }
        String[] notSoDepressedBalls = (balls.toString()).split(" ");
        int xDistance = 0;
        int zDistance = 0;
        for(int i = 0; i < notSoDepressedBalls.length; i ++){
            if(i % 2 == 0){ // even: direction
                if(notSoDepressedBalls[i].equals("forward")){ // x magnitude
                    xDistance += Integer.parseInt(notSoDepressedBalls[i+1]);
                }
                if(notSoDepressedBalls[i].equals("down")){ // x magnitude
                    zDistance += Integer.parseInt(notSoDepressedBalls[i+1]);
                }
                if(notSoDepressedBalls[i].equals("up")){ // x magnitude
                    zDistance -= Integer.parseInt(notSoDepressedBalls[i+1]);
                }
            }
        }
        return xDistance * zDistance;
    }

    /** TODO 4
     *
     * Challenge 4
     *
     * @param filename
     * @return Answer to Challenge 4
     * @throws FileNotFoundException
     */
    public static int challengeFour(String filename) throws FileNotFoundException {
        String[] depressingBalls = readFile2(filename);
        StringBuilder balls = new StringBuilder();
        for(int i = 0; i < depressingBalls.length; i ++ ){
            balls.append(depressingBalls[i]).append(" ");
        }
        String[] notSoDepressedBalls = (balls.toString()).split(" ");
        int xDistance = 0;
        int zDistance = 0;
        int aim = 0;

        for(int i = 0; i < notSoDepressedBalls.length; i ++){
            if(i % 2 == 0){ // even: direction
                if(notSoDepressedBalls[i].equals("forward")){ // x magnitude
                    xDistance += Integer.parseInt(notSoDepressedBalls[i+1]);
                    zDistance += Integer.parseInt(notSoDepressedBalls[i+1]) * aim;
                }
                if(notSoDepressedBalls[i].equals("down")){ // x magnitude
                    aim += Integer.parseInt(notSoDepressedBalls[i+1]);
                }
                if(notSoDepressedBalls[i].equals("up")){ // x magnitude
                    aim -= Integer.parseInt(notSoDepressedBalls[i+1]);
                }
            }
        }


        return xDistance * zDistance;
    }

    /** This method will write the values passed as challengeOne, challengeTwo, challengeThree, and challengeFour to a text file.
     * Do not edit this method.
     */
    private static void writeFileAllAnswers(String outPutFilename, int challengeOne, int challengeTwo, int challengeThree, int challengeFour) throws IOException {
        File file = new File(outPutFilename);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write("Challenge 1: " + "\t" + challengeOne + "\n");
        bufferedWriter.write("Challenge 2: " + "\t" + challengeTwo + "\n");
        bufferedWriter.write("Challenge 3: " + "\t" + challengeThree + "\n");
        bufferedWriter.write("Challenge 4: " + "\t" + challengeFour + "\n");
        bufferedWriter.close();
    }

    /** This method will read the values in inputFilename into an array of integers, which it will return.
     * Do not edit this method.
     */
    private static int[] readFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int numberOfLinesInFile = countLinesInFile(inputFilename);
        int[] data = new int[numberOfLinesInFile];
        int index = 0;
        while (scanner.hasNextLine()) {
            data[index++] = scanner.nextInt();
        }
        scanner.close();
        return data;
    }
    private static String[] readFile2(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int numberOfLinesInFile = countLinesInFile(inputFilename);
        String[] data = new String[numberOfLinesInFile];
        int index = 0;
        while (scanner.hasNextLine()) {
            data[index++] = scanner.nextLine();
        }
        scanner.close();
        return data;
    }

    /** This method will count the number of lines in a text file, which it will return.
     * Do not edit this method.
     */
    private static int countLinesInFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int lineCount = 0;
        while (scanner.hasNextLine()) {
            lineCount++;
            scanner.nextLine();
        }
        scanner.close();
        return lineCount;
    }

}