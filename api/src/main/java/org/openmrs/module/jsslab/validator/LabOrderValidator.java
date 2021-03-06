/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */
package org.openmrs.module.jsslab.validator;

import org.openmrs.annotation.Handler;
import org.openmrs.module.jsslab.db.LabOrder;
import org.openmrs.validator.OrderValidator;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Validates the {@link LabOrder} class.
 * 
 * @since 1.5
 */
@Handler(supports = { LabOrder.class }, order = 50)
public class LabOrderValidator extends OrderValidator implements Validator {
	
	/**
	 * Determines if the command object being submitted is a valid type
	 * 
	 * @see org.springframework.validation.Validator#supports(java.lang.Class)
	 */
	@SuppressWarnings("rawtypes")
	public boolean supports(Class c) {
		return LabOrder.class.isAssignableFrom(c);
	}
	
	/**
	 * Checks the form object for any inconsistencies/errors
	 * 
	 * @see org.springframework.validation.Validator#validate(java.lang.Object,
	 *      org.springframework.validation.Errors)
	 * @should fail validation if required fields are missing
	 */
	public void validate(Object obj, Errors errors) {
		super.validate(obj, errors);
		
		LabOrder order = (LabOrder) obj;
		if (order == null) {
			errors.rejectValue("order", "jsslab.validation.error.null");
		}
		
		// for the following elements LabOrder.hbm.xml says: not-null="true"
//		ValidationUtils.rejectIfEmpty(errors, "urgent", "jsslab.validation.nullField");
	}
}
