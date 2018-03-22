package com.acme.mailreader.domain;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.*;


import static org.junit.Assert.assertThat;

import org.hamcrest.core.Is;
import org.hamcrest.core.IsNot;
import org.junit.Before;
import org.junit.Test;

public class MailComparatorTest {
	
	private MailComparator comparator;

	@Before
	public void setUp() throws Exception {
		this.comparator = new MailComparator();
	}

	@Test
	public final void egauxSiDeuxMailsNuls() {
		Mail mail1 = null;
		Mail mail2 = null;
		assertThat(comparator.compare(mail1, mail2), is(MailComparator.EGAUX));
	}
	
	//Autres tests unitaires
	
	@Test
	public final void deuxiemeMailPlusImportant() {
		Mail mail1 = new Mail.Builder("sujet").important(false).build();
		Mail mail2 = new Mail.Builder("sujet").important(true).build();
		assertThat(comparator.compare(mail1, mail2), is(MailComparator.PREMIER_PLUS_PETIT));
	}
	
	@Test
	public final void sujetsNeSontPasEgaux() {
		Mail mail1 = new Mail.Builder("sujet1").build();
		Mail mail2 = new Mail.Builder("sujet2").build();
		assertThat(comparator.compare(mail1, mail2), is(not(MailComparator.EGAUX)));
	}
	
}
