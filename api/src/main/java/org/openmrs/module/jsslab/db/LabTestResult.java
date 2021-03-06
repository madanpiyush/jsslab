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
package org.openmrs.module.jsslab.db;

import java.io.Serializable;
import java.util.Locale;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.BaseOpenmrsData;
import org.openmrs.Concept;
import org.openmrs.Provider;
import org.openmrs.api.context.Context;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Root;

/**
 * A lab test result. This is included in the report.
 * 
 */
@Root(strict = false)
public class LabTestResult extends BaseOpenmrsData implements Serializable {
	
	public static final long serialVersionUID = 2L;
	
	private static final Log log = LogFactory.getLog(LabTestResult.class);
	
	private Integer testResultId;

	private LabTestSpecimen testSpecimen;
	
	private Concept testResultConcept;

	private LabResultType resultType;
	
	private Concept testAnswerConcept;
	
	private Double testAnswerDuration;
	
	private Integer testAnswerTiter;
	
	private Double testAnswerNumeric;
	
	private String testAnswerString;
	
	private String testAnswerFlag;
	
	private String testAnswerNote;

	private Double testNormalLow;
	
	private Double testNormalHigh;
	
	private Double testCriticalLow;
	
	private Double testCriticalHigh;
	
	private Boolean approved;
	
	private Provider approvedBy;
	
	private Boolean hidden;
	
	private Locale textLocale;
	
	private String testResultText;
	
	private String testAnswerConceptText;
	
	/**
	 * constructor 
	 */

	public LabTestResult() {
		this.setUuid(UUID.randomUUID().toString());
	}
	
	public LabTestResult(LabTestSpecimen testSpecimen) {
		this.setUuid(UUID.randomUUID().toString());
		this.testSpecimen = testSpecimen;
		testSpecimen.getTestResults().add(this);
	}
	
	@Override
	public int hashCode() {
		
		return this.getUuid().hashCode();
	}
	
	@Override
	public boolean equals(Object other) {
		try {
			LabTestResult temp = (LabTestResult) other;
			return this.getUuid().equals(temp.getUuid());		
		} catch (Exception e) {
			return false;
		}
	}

	public Integer getId() {
		return testResultId;
	}

	public void setId(Integer testResultId) {
		this.testResultId = testResultId;
	}

	public Integer gettestResultId() {
		return testResultId;
	}

	public void settestResultId(Integer testResultId) {
		this.testResultId = testResultId;
	}

	/**
	 * @return Returns the test specimen .
	 */
	@Attribute(required = true)
	public LabTestSpecimen getTestSpecimen() {
		return testSpecimen;
	}
	
	/**
	 * @param testSpecimen The testSpecimen to set.
	 */
	@Attribute(required = true)
	public void setTestSpecimen(LabTestSpecimen testSpecimen) {
		this.testSpecimen = testSpecimen;
	}
	
	/**
	 * @return Returns the testResultConcept concept.
	 */
	@Attribute(required = true)
	public Concept getTestResultConcept() {
		return testResultConcept;
	}
	
	/**
	 * @param testResultConcept The testResultConcept to set.
	 */
	@Attribute(required = false)
	public void setTestResultConcept(Concept testResultConcept) {
		this.testResultConcept = testResultConcept;
	}
	
	/**
	 * @return Returns the result type enum .
	 */
	@Attribute(required = true)
	public LabResultType getResultType() {
		return resultType;
	}
	
	/**
	 * @param resultType The resultType to set.
	 */
	@Attribute(required = true)
	public void setResultType(LabResultType resultType) {
		this.resultType = resultType;
	}
	
	/**
	 * @return Returns the result type enum as string.
	 */
	public String getResultTypeString() {
		return resultType.toString();
	}
	
	/**
	 * @return Returns the testAnswerConcept concept.
	 */
	@Attribute(required = false)
	public Concept getTestAnswerConcept() {
		return testAnswerConcept;
	}
	
	/**
	 * @param testAnswerConcept The testAnswerConcept to set.
	 */
	@Attribute(required = false)
	public void setTestAnswerConcept(Concept testAnswerConcept) {
		this.testAnswerConcept = testAnswerConcept;
	}
	
	/**
	 * @return Returns testAnswerDuration.
	 */
	@Attribute(required = false)
	public Double getTestAnswerDuration() {
		return testAnswerDuration;
	}
	
	/**
	 * @param testAnswerDuration.  The testAnswerDuration to set.
	 */
	@Attribute(required = false)
	public void setTestAnswerDuration(Double testAnswerDuration) {
		this.testAnswerDuration = testAnswerDuration;
	}
	
	/**
	 * @return Returns testAnswerTiter.
	 */
	@Attribute(required = false)
	public Integer getTestAnswerTiter() {
		return testAnswerTiter;
	}
	
	/**
	 * @param testAnswerTiter.  The testAnswerTiter to set.
	 */
	@Attribute(required = false)
	public void setTestAnswerTiter(Integer testAnswerTiter) {
		this.testAnswerTiter = testAnswerTiter;
	}
	
	/**
	 * @return Returns testAnswerNumeric.
	 */
	@Attribute(required = false)
	public Double getTestAnswerNumeric() {
		return testAnswerNumeric;
	}
	
	/**
	 * @param testAnswerNumeric.  The testAnswerNumeric to set.
	 */
	@Attribute(required = false)
	public void setTestAnswerNumeric(Double testAnswerNumeric) {
		this.testAnswerNumeric = testAnswerNumeric;
	}
	
	/**
	 * @return Returns testAnswerString.
	 */
	@Attribute(required = false)
	public String getTestAnswerString() {
		return testAnswerString;
	}
	
	/**
	 * @param testAnswerString.  The testAnswerString to set.
	 */
	@Attribute(required = false)
	public void setTestAnswerString(String testAnswerString) {
		this.testAnswerString = testAnswerString;
	}
	
	/**
	 * @return Returns testAnswerFlag.
	 */
	@Attribute(required = false)
	public String getTestAnswerFlag() {
		return testAnswerFlag;
	}
	
	/**
	 * @param testAnswerFlag.  The testAnswerFlag to set.
	 */
	@Attribute(required = false)
	public void setTestAnswerFlag(String testAnswerFlag) {
		this.testAnswerFlag = testAnswerFlag;
	}
	
	/**
	 * @return Returns testAnswerNote.
	 */
	@Attribute(required = false)
	public String getTestAnswerNote() {
		return testAnswerNote;
	}
	
	/**
	 * @param testAnswerNote.  The testAnswerNote to set.
	 */
	@Attribute(required = false)
	public void setTestAnswerNote(String testAnswerNote) {
		this.testAnswerNote = testAnswerNote;
	}
	
	/**
	 * @return Returns testNormalLow.
	 */
	@Attribute(required = false)
	public Double getTestNormalLow() {
		return testNormalLow;
	}
	
	/**
	 * @param testNormalLow.  The testNormalLow to set.
	 */
	@Attribute(required = false)
	public void setTestNormalLow(Double testNormalLow) {
		this.testNormalLow = testNormalLow;
	}
	
	/**
	 * @return Returns testNormalHigh.
	 */
	@Attribute(required = false)
	public Double getTestNormalHigh() {
		return testNormalHigh;
	}
	
	/**
	 * @param testNormalHigh.  The testNormalHigh to set.
	 */
	@Attribute(required = false)
	public void setTestNormalHigh(Double testNormalHigh) {
		this.testNormalHigh = testNormalHigh;
	}
	
	/**
	 * @return Returns testCriticalLow.
	 */
	@Attribute(required = false)
	public Double getTestCriticalLow() {
		return testCriticalLow;
	}
	
	/**
	 * @param testCriticalLow.  The testCriticalLow to set.
	 */
	@Attribute(required = false)
	public void setTestCriticalLow(Double testCriticalLow) {
		this.testCriticalLow = testCriticalLow;
	}
	
	/**
	 * @return Returns testCriticalHigh.
	 */
	@Attribute(required = false)
	public Double getTestCriticalHigh() {
		return testCriticalHigh;
	}
	
	/**
	 * @param testCriticalHigh.  The testCriticalHigh to set.
	 */
	@Attribute(required = false)
	public void setTestCriticalHigh(Double testCriticalHigh) {
		this.testCriticalHigh = testCriticalHigh;
	}
	
	/**
	 * @return Returns the approved flag.
	 */
	@Attribute(required = false)
	public Boolean getApproved() {
		return approved;
	}
	
	/**
	 * @return Returns the approved flag truth value.
	 */
	@Attribute(required = false)
	public Boolean isApproved() {
		return approved.equals(Boolean.TRUE);
	}
	
	/**
	 * @param approved.  The approved value to set.
	 */
	@Attribute(required = false)
	public void setApproved(Boolean approved) {
		this.approved = approved;
	}
	
	/**
	 * @return Returns the approvedBy.
	 */
	@Attribute(required = false)
	public Provider getApprovedBy() {
		return approvedBy;
	}
	
	/**
	 * @param approvedBy.  The approvedBy value to set.
	 */
	@Attribute(required = false)
	public void setApprovedBy(Provider approvedBy) {
		this.approvedBy = approvedBy;
	}
	
	/**
	 * @return Returns the hidden flag.
	 */
	@Attribute(required = false)
	public Boolean getHidden() {
		return hidden;
	}
	
	/**
	 * @return Returns the hidden flag truth value.
	 */
	@Attribute(required = false)
	public Boolean isHidden() {
		return hidden.equals(Boolean.TRUE);
	}
	
	/**
	 * @param hidden.  The hidden value to set.
	 */
	@Attribute(required = false)
	public void setHidden(Boolean hidden) {
		this.hidden = hidden;
	}
	/**
	 * Check for a locale change
	 */
	private void checkLocale() {
		if (textLocale == null) {
			testResultText = "";
			testAnswerConceptText = "";
			textLocale = Context.getLocale();
		}
		else if (! textLocale.equals(Context.getLocale())) {
			testResultText = "";
			testAnswerConceptText = "";
			textLocale = Context.getLocale();
		}
		return;
	}
	
	/**
	 * Get text corresponding to testResultConcept
	 */
	public String getTestResultText() {
		checkLocale();
		if (StringUtils.isEmpty(testResultText)) {
			if (! (testResultConcept == null)) {
				testResultText = Context.getConceptService().getConceptName(this.getTestResultConcept().getId()).getName();
			}
		}
		return testResultText;
	}

	/**
	 * Get text corresponding to testAnswerConcept
	 */
	public String getTestAnswerConceptText() {
		checkLocale();
		if (StringUtils.isEmpty(testAnswerConceptText)) {
			if (! (testAnswerConcept == null)) {
				testAnswerConceptText = Context.getConceptService().getConceptName(this.getTestAnswerConcept().getId()).getName();
				}
			}
		return testAnswerConceptText;
		}
	
	public String getTestValueText() {
		String s="";
		Double d1, d2;
		if (this.getResultType()==LabResultType.CONCEPT)
			return getTestAnswerConceptText();
		else if (this.getResultType()==LabResultType.DURATION) {
			if (this.getTestAnswerDuration()==null)
				return "";
			d1=this.getTestAnswerDuration() % 3600;
			d2=this.getTestAnswerDuration() - 3600 * d1;
			if (d1!=0)
				s=d1.toString() + "h ";
			d1= d2 % 60;
			d2= d2 - 60 * d1;
			s= s + d1.toString() + "m ";
			if (d2!=0)
				s= s+ d2.toString() +"s ";
			return s;
		} else if (this.getResultType()==LabResultType.NUMERIC) {
			d1=this.getTestAnswerNumeric();
			if (d1==null)
				return "";
			d2=Math.ceil(d1);
			if (Math.abs(d1-d2)<.001)
				return d2.toString();
			else
				return d1.toString();
		} else if (this.getResultType()==LabResultType.TITER) {
			if (this.getTestAnswerTiter()==null)
				return "";
			else
				return "1:" + this.getTestAnswerTiter();
		} else if (this.getResultType()==LabResultType.TEXT)
			if (this.getTestAnswerString()==null)
				return "";
			else 
				return this.getTestAnswerString();
		else
			return null;
	}

	public String getDisplayString() {
		String s=this.getTestResultText() + ": " + this.getTestValueText();
		if (this.getTestSpecimen()!=null) 
			if (this.getTestSpecimen().getSpecimen()!=null)
				return this.getTestSpecimen().getSpecimen().getLabSpecimenId() + " " + s;
		return s;
	}
	
	public String toString() {
		return "Result " + this.getId() + this.getTestValueText();
	}

	public void SetFlagFromValues() {
		String sH = "H";
		String sL = "L";
		Double d = this.getTestAnswerNumeric();
		if (this.getResultType()==LabResultType.TITER) {
			sH="L";
			sL="H";
			d=this.getTestAnswerTiter().doubleValue();
		} else if (this.getResultType()!=LabResultType.NUMERIC)
			return;
		if (d<this.getTestCriticalLow())
			this.setTestAnswerFlag(sL + sL);
		else if (d>this.getTestCriticalHigh())
			this.setTestAnswerFlag(sH + sH);
		else if (d<this.getTestNormalLow())
			this.setTestAnswerFlag(sL);
		else if (d>this.getTestNormalHigh())
			this.setTestAnswerFlag(sH);
		else
			this.setTestAnswerFlag("");
		return;
	}

}

