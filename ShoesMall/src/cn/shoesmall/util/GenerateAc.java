package cn.shoesmall.util;

public class GenerateAc {
    public static String generateAc()
    {
        StringBuilder stringBuilder = new StringBuilder();
        while(true)
        {
            if (stringBuilder.length() > 9)
            {
                break;
            }
            int number = (int)(Math.random() * 10);
            if (stringBuilder.length() == 0 && number == 0)
            {
                continue;
            }
            stringBuilder.append(number);
        }
        return stringBuilder.toString();
    }
}
