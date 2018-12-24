import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class ReadPDF {


    StringBuilder builder = new StringBuilder();
    //private final ArrayList<Integer> lowerCases = new ArrayList<>();
    private ArrayList<LowerCase> lowerCases= new ArrayList<>();

    public void Read() {

        int amountOfWords = 0;
        int amountOfChars = 0;
        String allAlphabate = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";


        System.out.println("Reading...........\n");

            try

            {
                PDDocument doc = PDDocument.load(new File("C:\\Users\\user\\Desktop\\article.pdf"));
                PDFTextStripper pdfTextStripper = new PDFTextStripper();
                String text = pdfTextStripper.getText(doc);


                String[] words = text.split(" ");
                amountOfWords = amountOfWords + words.length;


                for (String word : words) {
                    amountOfChars = amountOfChars + word.length();

                    Pattern pattern = Pattern.compile("[a-zA-Z]");
                    Matcher matcher = pattern.matcher(word);

                    while (matcher.find()) {
                        builder.append(matcher.group());

                    }

                }


            }catch (IOException e) {

            }


        String allData = builder.toString();
        int total = 0;

        for (int i=0;i<allAlphabate.length();i++)
        {
            int alphabateCount = 0;
            Pattern pattern = Pattern.compile(Character.toString(allAlphabate.charAt(i)));
            Matcher matcher = pattern.matcher(allData);
            while (matcher.find()) {
                alphabateCount++;
            }
            total+=alphabateCount;
            LowerCase lowerCase = new LowerCase(alphabateCount);
            lowerCases.add(lowerCase);
            System.out.println("Alphabate : "+ allAlphabate.charAt(i) +" -> Count is "+alphabateCount);
        }
        if(total == builder.toString().length())
        {
            System.out.println("\nTotal number of character is : "+ total);
        }


        System.out.println("Amount of Words is " + (amountOfWords));
        //  System.out.println(lowerCases);

    }

    public ArrayList<LowerCase> getLowerCases(){
        return lowerCases;
    }

}