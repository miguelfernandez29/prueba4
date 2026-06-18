package com.example.app.service;

import org.springframework.stereotype.Service;

import java.math.BigInteger;

@Service
public class ValidationService {

    public boolean validateIBAN(String iban) {
        if (iban == null || iban.trim().isEmpty()) {
            return true;
        }

        String cleanIban = iban.replaceAll("\\s+", "").toUpperCase();

        if (cleanIban.length() < 15 || cleanIban.length() > 34) {
            return false;
        }

        if (!cleanIban.matches("[A-Z]{2}[0-9]{2}[A-Z0-9]+")) {
            return false;
        }

        String rearranged = cleanIban.substring(4) + cleanIban.substring(0, 4);

        StringBuilder numericIban = new StringBuilder();
        for (char c : rearranged.toCharArray()) {
            if (Character.isLetter(c)) {
                numericIban.append(c - 'A' + 10);
            } else {
                numericIban.append(c);
            }
        }

        try {
            BigInteger ibanNumber = new BigInteger(numericIban.toString());
            return ibanNumber.mod(BigInteger.valueOf(97)).intValue() == 1;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean validateCadastralReference(String reference) {
        if (reference == null || reference.trim().isEmpty()) {
            return true;
        }

        String cleanRef = reference.replaceAll("\\s+", "");
        return cleanRef.length() == 20;
    }

    public boolean validateNIF(String nif) {
        if (nif == null || nif.trim().isEmpty()) {
            return true;
        }

        String cleanNif = nif.trim().toUpperCase();

        if (cleanNif.length() != 9) {
            return false;
        }

        if (cleanNif.matches("[0-9]{8}[A-Z]")) {
            String letters = "TRWAGMYFPDXBNJZSQVHLCKE";
            int number = Integer.parseInt(cleanNif.substring(0, 8));
            char expectedLetter = letters.charAt(number % 23);
            return cleanNif.charAt(8) == expectedLetter;
        }

        if (cleanNif.matches("[KLMXYZ][0-9]{7}[A-Z]")) {
            String letters = "TRWAGMYFPDXBNJZSQVHLCKE";
            char firstChar = cleanNif.charAt(0);
            String numericPart;
            switch (firstChar) {
                case 'K':
                case 'L':
                case 'M':
                    numericPart = "0" + cleanNif.substring(1, 8);
                    break;
                case 'X':
                    numericPart = "0" + cleanNif.substring(1, 8);
                    break;
                case 'Y':
                    numericPart = "1" + cleanNif.substring(1, 8);
                    break;
                case 'Z':
                    numericPart = "2" + cleanNif.substring(1, 8);
                    break;
                default:
                    return false;
            }
            int number = Integer.parseInt(numericPart);
            char expectedLetter = letters.charAt(number % 23);
            return cleanNif.charAt(8) == expectedLetter;
        }

        if (cleanNif.matches("[ABCDEFGHJNPQRSUVW][0-9]{7}[0-9A-J]")) {
            return true;
        }

        return false;
    }
}