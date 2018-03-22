package com.acme.mailreader.domain;

import java.time.Instant;

import org.junit.Ignore;
import org.junit.Test;

import com.acme.mailreader.utils.DateIncorrecteException;

public class MailTest {
	
	@Test(expected=DateIncorrecteException.class)
	public final void erreurSiDateAvant1970() throws DateIncorrecteException {
		Mail mail1 = new Mail();
		mail1.setDate(Instant.parse("1968-01-01T00:00:00.00Z"));
		
	}
	
	@Test(expected=DateIncorrecteException.class)
	public final void erreurSiDateApres2100() throws DateIncorrecteException {
		Mail mail1 = new Mail();
		mail1.setDate(Instant.parse("2101-01-01T00:00:00.00Z"));
		
	}
	
	

}
