package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

import org.junit.Test;

public class TormatTest {
	@Test
	public void test() throws ParseException{
		Long l=1507651200000l;
		String s="1999-01-01";
		SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
		String newdate  = myFormat.format(l);
		Long parse = myFormat.parse(s).getTime();
		System.out.println(newdate);
		
	}
}
