//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2020.02.01 at 11:32:21 PM CET 
//


package ftn.xscience.model.review;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TRevisionEvaluation.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TRevisionEvaluation">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="STRONGLY_AGREE"/>
 *     &lt;enumeration value="AGREE"/>
 *     &lt;enumeration value="NEUTRAL"/>
 *     &lt;enumeration value="DISAGREE"/>
 *     &lt;enumeration value="STRONGLY_DISAGREE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TRevisionEvaluation")
@XmlEnum
public enum TRevisionEvaluation {

    STRONGLY_AGREE,
    AGREE,
    NEUTRAL,
    DISAGREE,
    STRONGLY_DISAGREE;

    public String value() {
        return name();
    }

    public static TRevisionEvaluation fromValue(String v) {
        return valueOf(v);
    }

}
