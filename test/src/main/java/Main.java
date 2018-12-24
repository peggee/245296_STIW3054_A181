import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        final long start=System.currentTimeMillis();

        ReadPDF readPDF = new ReadPDF();
        readPDF.Read();

        Standard_Deviation standard_deviation = new Standard_Deviation();
        standard_deviation.StandardDeviation(readPDF.getLowerCases());


        Z_Score z_score = new Z_Score();
        z_score.Cal(readPDF.getLowerCases());


        System.out.println("\n\nEnd of the program");
        long end=System.currentTimeMillis();
        long duration=end-start;
        System.out.println("Running is: "+duration+"ms.");


    }
}
