import java.text.SimpleDateFormat;
import java.util.Date;

public class Formatter {

        public static String Formatt(Date date) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MMM/yyyy");
                return simpleDateFormat.format(date).toUpperCase();
        }

}
