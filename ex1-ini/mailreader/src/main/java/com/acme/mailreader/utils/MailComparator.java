package com.acme.mailreader.utils;

import java.util.Comparator;

import com.acme.mailreader.model.Mail;

/**
 * Comparateur de mails
 * 
 * Comme on désire afficher les mails les plus importants en premier, l'element le plus grand retourne une valeur négative
 *
 */
public class MailComparator implements Comparator<Mail> {

	public int compare(Mail mail1, Mail mail2) {
		if (unDesMailsEstNul(mail1, mail2)) {
			return 0;
		}
		if (pasLaMemeImportance(mail1, mail2)) {
			return trierParImportance(mail1, mail2);
		}
		if (pasLeMemeStatut(mail1, mail2)) {
			return trierParStatut(mail1, mail2);
		}
		if (pasLeMemeSujet(mail1, mail2)) {
			return trierParSujet(mail1, mail2);
		}
		return trierParDate(mail1, mail2);
	}

	private int trierParDate(Mail mail1, Mail mail2) {
		return mail2.getDate().compareTo(mail1.getDate());
	}

	private int trierParSujet(Mail mail1, Mail mail2) {
		return mail2.getSujet().compareTo(mail1.getSujet());
	}

	private boolean pasLeMemeSujet(Mail mail1, Mail mail2) {
		return mail1.getSujet() != mail2.getSujet();
	}

	private int trierParStatut(Mail mail1, Mail mail2) {
		int comp = mail1.getStatut().ordinal()
				- mail2.getStatut().ordinal();
		return comp > 0 ? -1 : 1;
	}

	private boolean pasLeMemeStatut(Mail mail1, Mail mail2) {
		return mail1.getStatut() != mail2.getStatut();
	}

	private int trierParImportance(Mail mail1, Mail mail2) {
		if (mail1.isImportant() && !mail2.isImportant()) {
			return -1;
		} else {
			return 1;
		}
	}

	private boolean pasLaMemeImportance(Mail obj1, Mail obj2) {
		return obj1.isImportant() != obj2.isImportant();
	}

	private boolean unDesMailsEstNul(Mail obj1, Mail obj2) {
		return obj1 == null || obj2 == null;
	}
}
