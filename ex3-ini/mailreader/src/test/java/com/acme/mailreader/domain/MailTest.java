package com.acme.mailreader.domain;

import java.time.Instant;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

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
	
	@Test
	public final void vraiSiMailImportant() {
		Mail mail = new Mail();
		mail.setImportant(true);
		
		assertThat(mail.isImportant(), is(true));		
		
	}	
	
	@SuppressWarnings("null")
	@Test
	public final void egauxSiDeuxMailsInstanciesSimplement() {
		Mail mail1 = new Mail();
		Mail mail2 = new Mail();
		assertThat(mail1.equals(mail2), is(true));
		
	}
	
	public final void differentSiUnMailSansAttribut() {
		Mail mail1 = new Mail();
		mail1.setImportant(true);
		Mail mail2 = new Mail();
		
		assertThat(mail1.equals(mail2), is(false));
	}
	


}
