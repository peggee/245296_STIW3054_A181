import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

import java.util.ArrayList;


public class Standard_Deviation {

    public void StandardDeviation(ArrayList<LowerCase> character) throws InterruptedException {


        DescriptiveStatistics descriptiveStatistics = new DescriptiveStatistics();
        for (
                LowerCase v : character) {
            descriptiveStatistics.addValue(v.getA());
        }

        double mean = descriptiveStatistics.getMean();
        double median = descriptiveStatistics.getPercentile(50);
        double standardDeviation = descriptiveStatistics.getStandardDeviation();

        Thread.sleep(1000);
        {
            System.out.printf("\nStandard Deviation is: %.2f" ,standardDeviation );

        }


    }
}
