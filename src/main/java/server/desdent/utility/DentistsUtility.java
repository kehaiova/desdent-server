package server.desdent.utility;

import org.passay.CharacterData;
import org.passay.CharacterRule;
import org.passay.PasswordGenerator;
import server.desdent.exception.BadRequestException;

import java.util.List;

import static org.passay.EnglishCharacterData.*;

public class DentistsUtility {
    public static boolean isValidPass(String password) {
        if (password == null) {
            throw new BadRequestException("Password is mandatory!");
        }
        boolean result = false;
        //At least one upper case, one lower case,one digit,one special character minimum eight characters , max 20
        String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";
        if (password.matches(regex) && !password.contains(" ")) {
            result = true;
        }
        return result;
    }

    public static boolean passwordsMatch(String password1, String password2) {
        return password1.equals(password2);
    }

    public static String generateRandomPassword() {
        PasswordGenerator gen = new PasswordGenerator();
        CharacterData lowerCaseChars = LowerCase;
        CharacterRule lowerCaseRule = new CharacterRule(lowerCaseChars);
        lowerCaseRule.setNumberOfCharacters(2);

        CharacterData upperCaseChars = UpperCase;
        CharacterRule upperCaseRule = new CharacterRule(upperCaseChars);
        upperCaseRule.setNumberOfCharacters(2);

        CharacterData digitChars = Digit;
        CharacterRule digitRule = new CharacterRule(digitChars);
        digitRule.setNumberOfCharacters(2);

        CharacterData specialChars = new CharacterData() {
            public String getErrorCode() {
                return "ERROR_CODE";
            }

            public String getCharacters() {
                return "!@#$%^&*()_+";
            }
        };
        CharacterRule splCharRule = new CharacterRule(specialChars);
        splCharRule.setNumberOfCharacters(2);

        String password = gen.generatePassword(20, splCharRule, lowerCaseRule,
                upperCaseRule, digitRule);
        return password;
    }

    public static boolean isValidEmail(String email) {
        if (email == null) {
            throw new BadRequestException("Email is mandatory!");
        }
        boolean result = false;
        boolean emailSymbolFound = false;
        String specialCharacters = "#?!@$%^&*-:'{}+_()<>|[]";
        //Letters, numbers and "_","." before "@" symbol
        String regex = "^[A-Za-z0-9+_.]+@(.+)$";
        if (email.matches(regex)) {
            int startCharacter = 0;
            for (int i = 0; i < email.length(); i++) {
                if (email.charAt(i) == '@') {
                    if (!emailSymbolFound) {
                        startCharacter = i;
                        emailSymbolFound = true;
                    }
                }
            }
            for (int i = startCharacter + 1; i < email.length(); i++) {
                char character = email.charAt(i);
                if (!specialCharacters.contains(String.valueOf(character)) && !Character.isDigit(character) && !Character.isSpaceChar(character)) {
                    result = true;
                } else {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }

    public static boolean isValidMobilePhone(String mobilePhone) {
        mobilePhone = mobilePhone.trim();
        if (mobilePhone.length() == 10) {
            if (!mobilePhone.startsWith("08") && !mobilePhone.matches("^[0-9]*$")) {
                return false;
            }
            return true;
        } else if (mobilePhone.length() == 13) {
            if (!mobilePhone.startsWith("+3598") && mobilePhone.substring(1, 13).matches("^[0-9]*$")) {
                return false;
            }
            return true;
        }
        return false;
    }
}
