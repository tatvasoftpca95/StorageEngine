package com.tatva.utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;

import com.tatva.exceptionhandling.BusinessException;
import com.tatva.exceptionhandling.ValidationException;

public class Validations {
	/*
	 * Returns the list of errors of a binding result
	 */
	public static void validate(BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new ValidationException(bindingResult);
		}
	}
	
	/*
	 * Checks if a list is empty
	 */
	public static void isEmpty (List<?> list) {
		if (list.isEmpty()) {
			throw new BusinessException(ResponseCode.CFG_NO_DATA_FOUND, HttpStatus.OK);
		}
	}
	
	public static void isPageEmpty (Page<?> page) {
		if (page.isEmpty()) {
			throw new BusinessException(ResponseCode.CFG_NO_DATA_FOUND, HttpStatus.NOT_FOUND);
		}
	}
	
	/*
	 * Checks if a string is numeric
	 */
	public static Boolean isNumeric(String value) {
		if (value.trim().matches("[0-9 ]+")) {
			return true; 
		}
		return false; 
	}
	
	/*
	 * Checks if a string is alpha numeric
	 */
	public static Boolean isAlphaNumeric(String value) {
		if (value.trim().matches("[a-zA-Z0-9 ]*")) {
			return true; 
		}
		return false; 
	}
	
//	/*
//	 * Checks if the difference in days between 2 dates is within configured range   
//	 */ 
//	public static void isValidDateRange (Date fromDate, Date toDate, int dateRange) {
//		long difference_in_time = TimeUnit.DAYS.convert((toDate.getTime() - fromDate.getTime()), TimeUnit.MILLISECONDS);
//		if(difference_in_time > dateRange) {
//			throw new BusinessException(ResponseCode.CFG_INVALID_DATE_RANGE, HttpStatus.NOT_FOUND);
//		}
//	}
	
	/*
	 * Validates the password based on the password policy 
	 */
//	public static void isValidPassword (PasswordPolicy passwordPolicy, String password, List<PasswordHistory> passwordHistory, PasswordEncoder passwordEncoder) {
//		if(password.trim().length() < passwordPolicy.getPasswordLength()) {
//			throw new BusinessException (ResponseCode.CFG_INVALID_PASSWORD_LENGTH, HttpStatus.BAD_REQUEST); 
//		}
//		if (Objects.nonNull(passwordHistory) && passwordHistory.isEmpty()) {
//			passwordHistory.stream().forEach((passHist)->{
//				if (passwordEncoder.matches(password.trim(), passHist.getPassword())){
//					throw new BusinessException(ResponseCode.CFG_INVALID_PASSWORD_ALREADY_USED, HttpStatus.BAD_REQUEST); 
//				}
//			});
//		}
//		String passwordFormat = "[";
//		if(passwordPolicy.getLowerFlag().trim().equalsIgnoreCase("1")) {
//			passwordFormat += "a-z";
//		}
//		if(passwordPolicy.getUpperFlag().trim().equalsIgnoreCase("1")) {
//			passwordFormat += "A-Z";
//		}
//		if(passwordPolicy.getNumberFlag().trim().equalsIgnoreCase("1")) {
//			passwordFormat += "0-9";
//		}
//		if(passwordPolicy.getSpecialCharactersFlag().trim().equalsIgnoreCase("1") && 
//				!Pattern.compile(passwordFormat+passwordPolicy.getSpecialCharactersList()+"]+").matcher(password).matches()) {
//			throw new BusinessException(ResponseCode.CFG_INVALID_PASSWORD,HttpStatus.BAD_REQUEST);
//		}
//	}
	
	/*
	 * Pads the string to the left with the padChar 
	 */
	public static String leftPad(String s, String padChar, int totalLength) {
		if (s == null)
			s = "";
		StringBuffer newS = new StringBuffer(s);
		while (newS.length() < totalLength)
			newS.insert(0, padChar);
		return newS.toString();
	}
	
	/*
	 * Pads the string to the right with the padChar 
	 */
	public static String rightPad(String s, String padChar, int totalLength) {
	    StringBuffer newS=new StringBuffer(s);
	    while (newS.length()<totalLength)
	    	newS.append(padChar);
	    return newS.toString();
	}
	
	/*
	 * Checks if all values inside a list are unique
	 */
	public static <T> boolean areAllUnique(List<T> list){
	    Set<T> set = new HashSet<>();
	    return list.stream().allMatch(t -> set.add(t));
	}
	
	/*
	 * Check if all numeric values from 1 to list size exist
	 */
	public static Boolean allPositionsExist (List<Integer> list) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) != (i+1)) {
				return false;
			}
		}
		return true;
	}
	
	/*
	 * Validates from/to dates 
	 * From date cannot be greater that to date 
	 * From date and to date cannot be greater than system date
	 */
//	public static void dateValidations (Date fromDate, Date toDate) {
//		long now = System.currentTimeMillis();
//        Date systemDate = new Date(now);
//		
//		if(fromDate.compareTo(toDate) > 0) {
//			throw new BusinessException(ResponseCode.VAL_FROM_DATE_GREATER_TO_DATE, HttpStatus.BAD_REQUEST);
//		} 
//		
//		if(fromDate.compareTo(systemDate) > 0) {
//			throw new BusinessException(ResponseCode.VAL_FROM_DATE_GREATER_SYSDATE, HttpStatus.BAD_REQUEST);
//		} 
//		
//		if(toDate.compareTo(systemDate) > 0) {
//			throw new BusinessException(ResponseCode.VAL_TO_DATE_GREATER_SYSDATE, HttpStatus.BAD_REQUEST);
//		} 
//	}
	
	/*
	 * From date cannot be greater that to date 
	 */
//	public static void dateValidationsFromGreaterThanTo (Date fromDate, Date toDate) {
//		if(fromDate.compareTo(toDate) > 0) {
//			throw new BusinessException(ResponseCode.VAL_FROM_DATE_GREATER_TO_DATE, HttpStatus.BAD_REQUEST);
//		} 
//	}
	
	
}